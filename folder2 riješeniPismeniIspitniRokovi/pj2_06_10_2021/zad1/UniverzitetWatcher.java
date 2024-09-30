
import java.nio.file.*;
import java.io.*;
import java.util.concurrent.*;

public class UniverzitetWatcher extends Thread{
	
	public Path folderPath;
	public Univerzitet univerzitet;
	
	// Constructor
	public UniverzitetWatcher(Path folderPath,Univerzitet univerzitet){
		this.folderPath=folderPath;
		this.univerzitet=univerzitet;
	}
	
	@Override
	public void run(){
		
		try{
				//	1) Dakle, prvi korak jeste da se kreira jedan objekat WatchService klase!!
			WatchService watchService=FileSystems.getDefault().newWatchService();
			/*
 			* 	Sada kada imamo WatchService instancu i direktorijum koji želimo pratiti,
 			* 	potrebno je registrirati taj direktorijum sa WatchService-om.
 			* 	Registracija omogućava praćenje događaja poput kreiranja novih fajlova u direktorijumu.
 			*/
			//	2) Drugi korak jeste da direktorijum regirstrujemo na WatchService, specijalizacija(ENTRY_CREATE) iako ih ukupno ima 4..
			this.folderPath.register(watchService,StandardWatchEventKinds.ENTRY_CREATE);
			while(Main.running){
				/*
 				* U praćenom direktorijumu, svaki put kada se desi neki novi događaj, to se signalizira.
 				* Signal se interpretira kao WatchKey objekat.
 				* Zbog toga je potreban "hvatač" događaja za obradu tih signala.
 				*/

				//	 3) Treći korak jeste da se u objekat klase WatchKey pohrane događaji..
				WatchKey watchKey=null;
				try{
					watchKey=watchService.poll(3000,TimeUnit.MILLISECONDS);
				}
				catch(InterruptedException e){
					System.out.println("PREKID!!");
				}
				// 4) Četvrti korak..
				if(watchKey!=null){
					for(WatchEvent<?>event:watchKey.pollEvents()){
						
						WatchEvent.Kind<?> kind=event.kind();						//	tip događaja
						WatchEvent<Path> eventPath=(WatchEvent<Path>)event;			//	lokacija događaja
						Path path=eventPath.context();								//	uzročnik događaja
						if(kind.equals(StandardWatchEventKinds.ENTRY_CREATE)){
							
							String fileName=path.getFileName().toString();
							String fakultetIme=fileName.substring(0,fileName.length()-4);
							try{
								
								Fakultet fakultet=new Fakultet(fakultetIme);
								Fakultet.readStudents(fakultet,Paths.get(this.folderPath.toString(),path.toString()));
								synchronized(this.univerzitet){
									this.univerzitet.dodajFakultet(fakultet);
								}
							}
							catch(StudentFileException e){
								System.out.println("Greska prilikom kreiranja fakulteta");
								System.out.println(e.getMessage());
							}
						}
					}
					boolean status=watchKey.reset();
					if(!status)
						break;
				}
			}
		}
		catch(IOException E){
			System.out.println("Trenutno nije moguce vrsiti nadzor nad putanjom"+this.folderPath.toString());
		}
	}
}
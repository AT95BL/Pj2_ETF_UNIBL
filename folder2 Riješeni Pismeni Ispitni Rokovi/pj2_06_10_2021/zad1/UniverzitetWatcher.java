
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

/*
 * Evo objašnjenja ovih triju linija koda u kontekstu praćenja promena u fajl sistemu korišćenjem Java NIO paketa (`java.nio.file`), 
 * obično sa klasama kao što su **`WatchService`**, **`WatchKey`**, i **`WatchEvent`**.

### 1. **`WatchEvent.Kind<?> kind = event.kind();`**
- **`WatchEvent`** je interfejs koji predstavlja događaj koji se javlja u fajl sistemu, 
	kao što su kreiranje, brisanje ili modifikacija fajla.
- **`kind()`** metoda vraća tip događaja, odnosno njegovu vrstu. 
	Vrste događaja su predefinisane u `WatchEvent.Kind` interfejsu, kao što su:
  - `StandardWatchEventKinds.ENTRY_CREATE` (kreiranje fajla)
  - `StandardWatchEventKinds.ENTRY_DELETE` (brisanje fajla)
  - `StandardWatchEventKinds.ENTRY_MODIFY` (modifikacija fajla)
  
  **`<?>`** u `Kind<?>` znači da tip može biti bilo koji generički tip. 
  U kontekstu praćenja fajlova, najčešće je to `Path`, ali `Kind<?>` omogućava fleksibilnost za druge tipove događaja.

- Ova linija znači da se iz događaja (`event`) dobija vrsta (tip) događaja i čuva u promenljivoj `kind`.

### 2. **`WatchEvent<Path> eventPath = (WatchEvent<Path>) event;`**
- Ova linija koristi **downcast** (ručno kastovanje) iz generičkog tipa **`WatchEvent<?>`** u **`WatchEvent<Path>`**.
  
- Razlog za kastovanje je taj što, iako je `event` generalno tipa `WatchEvent<?>`, 
kada radimo sa fajlovima, događaji su povezani sa putanjama (`Path`), tako da je bezbedno pretpostaviti da je stvarni tip 
događaja `WatchEvent<Path>`.

- **`WatchEvent<Path>`** znači da ovaj događaj odnosi na putanje fajlova (`Path`).

### 3. **`Path path = eventPath.context();`**
- **`context()`** metoda iz `WatchEvent<Path>` vraća specifičan kontekst događaja. 
U slučaju događaja vezanih za fajlove, 
kontekst je obično relativna putanja (`Path`) fajla ili direktorijuma koji je izazvao događaj.

- Ova linija preuzima tu putanju i smešta je u promenljivu **`path`**. 

### Sumirano:
- Prva linija uzima vrstu događaja (kreiranje, brisanje, modifikacija).
- Druga linija kastuje generički događaj u tip specifičan za fajlove (`Path`).
- Treća linija izdvaja putanju fajla ili direktorijuma koji je pogođen događajem.

Ove linije bi se koristile u sistemima za praćenje promena u fajl sistemu kako bi se prepoznalo koji fajl ili direktorijum je promenjen, 
kreiran, ili obrisan.
*/
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
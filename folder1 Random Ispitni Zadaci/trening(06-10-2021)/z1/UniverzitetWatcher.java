
import java.nio.file.*;
import java.io.*;
import java.util.concurrent.*;

public class UniverzitetWatcher extends Thread{
	public Path folderPath;
	public Univerzitet univerzitet;

	// Constructor
	public UniverzitetWatcher(Path folderPath, Univerzitet univerzitet){
		this.folderPath=folderPath;
		this.univerzitet=univerzitet;
	}

	@Override
	public void run(){
		try{

			WatchService watchService=FileSystems.getDefault().newWatchService();
			this.folderPath.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);

			while(Main.running){

				WatchKey watchKey=null;
				try{
					watchKey=watchService.poll(3000, TimeUnit.MILLISECONDS);
				}catch(InterruptedException ex){
					ex.printStackTrace();
				}
				
				// -------------------------------------------------------------------------------
				if(watchKey != null){
					for(WatchEvent<?>event:watchKey.pollEvents()){
						WatchEvent.Kind<?> kind=event.kind();
						WatchEvent<Path> eventPath=(WatchEvent<Path>)event;
						Path path=eventPath.context();
						if(kind.equals(StandardWatchEventKinds.ENTRY_CREATE)){
							String fileName=path.getFileName().toString();
							String nazivFakulteta=fileName.substring(0, fileName.length()-4);
							try{
								Fakultet fakultet=new Fakultet(nazivFakulteta);
								Fakultet.readStudents(fakultet, Paths.get(this.folderPath.toString(), path.toString()));
								synchronized(this.univerzitet){
									this.univerzitet.dodajFakultet(fakultet);
								}
							}catch(StudentFileException ex){
								ex.printStackTrace();
							}
						}
					}
					boolean status=watchKey.reset();
					if(!status){
						break;
					}
				}

			}
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
}
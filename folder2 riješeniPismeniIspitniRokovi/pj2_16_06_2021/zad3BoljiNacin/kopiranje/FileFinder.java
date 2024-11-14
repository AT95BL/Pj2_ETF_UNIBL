
import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class FileFinder implements FileVisitor<Path>{
	
	Path pocetniDirektorijum;
	String ekstenzija;
	Path destinacioniDirektorijum;
	ArrayList<Path> putanje = new ArrayList<>();
	HashMap<Path,Integer> mapa = new HashMap<>();
	
	public FileFinder(Path pocetniDirektorijum, String ekstenzija, Path destinacioniDirektorijum){
		this.pocetniDirektorijum = pocetniDirektorijum;
		this.ekstenzija = ekstenzija;
		this.destinacioniDirektorijum = destinacioniDirektorijum;
	}
	
	@Override
	public FileVisitResult postVisitDirectory(Path dirPath, IOException ex)throws IOException{
		return FileVisitResult.CONTINUE;
	}
	
	@Override
	public FileVisitResult preVisitDirectory(Path dirPath, BasicFileAttributes attrs)throws IOException{
		return FileVisitResult.CONTINUE;
	}
	
	@Override
	public FileVisitResult visitFile(Path filePath, BasicFileAttributes attrs)throws IOException{
		
		if(filePath.toString().endsWith(this.ekstenzija)){
			System.out.println(filePath.getFileName().toString() + "Pronađen!");
			putanje.add(filePath);
			
			if(mapa.containsKey(filePath)){
				int pom = mapa.get(filePath);
				pom++;
				mapa.put(filePath, pom);
			}
			else{
				mapa.put(filePath, 1);
			}
		}
		return FileVisitResult.CONTINUE;
	}
	
	@Override
	public FileVisitResult visitFileFailed(Path filePath, IOException ex)throws IOException{
		return FileVisitResult.CONTINUE;
	}
	
	@Override
	public String toString(){
		return "(" + pocetniDirektorijum.toString() + ", " + ekstenzija + ", " + destinacioniDirektorijum + ")";
	}
	
	public void copyAllFiles(){
		for(var putanja:this.putanje){
			try{
				Path novaPutanja = Paths.get(destinacioniDirektorijum.toString(), putanja.getFileName().toString());
				Files.copy(putanja, novaPutanja);
			}catch(IOException ex){
				ex.printStackTrace();
			}
		}
	}
	
	public void printMap(){
		for( Map.Entry<Path,Integer> entry : mapa.entrySet()){
			String key = entry.getKey().toString();
			String value = entry.getValue().toString();
			System.out.println(key + value);
		}
	}
}
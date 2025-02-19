
import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class Pretrazivac implements FileVisitor<Path>{
	
	Path putanjaPocetnogDirektorijuma = null;
	String ekstenzija = "";
	
	List<Path> listaPutanja = new ArrayList<>();
	Map<Path, Integer> mapa = new HashMap<>();
	
	// Constructor
	public Pretrazivac(){
		
	}
	
	// Constructor
	public Pretrazivac(Path putanjaPocetnogDirektorijuma, String ekstenzija){
		this.putanjaPocetnogDirektorijuma = putanjaPocetnogDirektorijuma;
		this.ekstenzija = ekstenzija;
	}
	
	@Override
	public FileVisitResult postVisitDirectory(Path direktorijumPutanja, IOException nebitno)throws IOException{ 
		return FileVisitResult.CONTINUE;
	}
	
	@Override
	public FileVisitResult preVisitDirectory(Path direktorijumPutanja, BasicFileAttributes nebitno)throws IOException{ 
		return FileVisitResult.CONTINUE; 
	}
	
	@Override
	public FileVisitResult visitFile(Path datotekaPutanja, BasicFileAttributes nebitno)throws IOException{ 
		pretraga(datotekaPutanja);
		return FileVisitResult.CONTINUE; 
	}
	
	@Override
	public FileVisitResult visitFileFailed(Path datotekaPutanja, IOException nebitno)throws IOException{ 
		return FileVisitResult.CONTINUE; 
	}
	
	public void pretraga(Path datotekaPutanja){
		if(datotekaPutanja.getFileName().toString().endsWith(ekstenzija)){
			
			listaPutanja.add(datotekaPutanja);
			
			if(mapa.containsKey(datotekaPutanja)){
				int brojac = mapa.get(datotekaPutanja);
				brojac++;
				mapa.put(datotekaPutanja, brojac);
			
			}else{
				mapa.put(datotekaPutanja, 1);
			}
		}
	}
	
	public void print(){
		for(Map.Entry<Path,Integer> entry:mapa.entrySet()){
			String key = entry.getKey().toString();
			String value = entry.getValue().toString();
			System.out.println("<" + key + "," + value + ">");
		}
	}
}
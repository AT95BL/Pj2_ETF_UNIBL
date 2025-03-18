
import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.util.*;

public class Pretrazivac implements FileVisitor<Path>{
	
	String rijec = "";
	String ekstenzija = "";
	Path putanjaPocetnogDirektorijuma = null;
	
	List<Path> listaPutanja = new ArrayList<>();
	Map<Path, Integer> mapaPutanja = new HashMap<>();
	
	// Constructor
	public Pretrazivac(){
		
	}
	
	// Constructor
	public Pretrazivac(String rijec, String ekstenzija, Path putanjaPocetnogDirektorijuma){
		this.rijec = rijec;
		this.ekstenzija = ekstenzija;
		this.putanjaPocetnogDirektorijuma = putanjaPocetnogDirektorijuma;
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
		pronadji(datotekaPutanja);
		return FileVisitResult.CONTINUE;
	}
	
	@Override
	public FileVisitResult visitFileFailed(Path datotekaPutanja, IOException nebitno)throws IOException{
		return FileVisitResult.CONTINUE;
	}
	
	/*
		Sve ovo se moglo raspisati unutar metode 'visitFile'
		ali, uvijek preglednosti radi, kasnije i radi uocavanja/otklona problema,
		izolacija je bolje rjesenje, a i u skladu je sa SOLID principima..
		
	*/
	public void pronadji(Path datotekaPutanja){
		
		if(datotekaPutanja.getFileName().toString().endsWith(ekstenzija)){
			try{
				List<String> linijeDatoteke = Files.readAllLines(datotekaPutanja);
				
				for(String linijaDatoteke:linijeDatoteke){
					
					if(linijaDatoteke.contains(rijec)){
						listaPutanja.add(datotekaPutanja);
						
						if(mapaPutanja.containsKey(datotekaPutanja)){
							int brojac = mapaPutanja.get(datotekaPutanja);
							brojac++;
							mapaPutanja.put(datotekaPutanja, brojac);
						}else{
							int brojac=1;
							mapaPutanja.put(datotekaPutanja, brojac);
						}
					}
				}
				
			}catch(Exception ex){ 
				ex.printStackTrace();
			}
		}
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		
		for(Map.Entry<Path, Integer> entry:this.mapaPutanja.entrySet()){
			String key = entry.getKey().toString();
			String value = entry.getValue().toString();
			sb.append("(" + key + "," + value + ")" + "\n");
		}
		
		return sb.toString();
	}
}
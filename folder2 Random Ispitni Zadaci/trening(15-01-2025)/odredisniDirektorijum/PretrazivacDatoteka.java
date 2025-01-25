
import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class PretrazivacDatoteka implements FileVisitor<Path>{
	
	String ekstenzija = " ";
	Path putanjaPocetnogDirektorijuma = null;
	Path putanjaOdredisnogDirektorijuma = null;
	List<Path> listaPutanjaDatotekaSaOdgovarajucomEkstenzijom = new ArrayList<>();
	Map<Path, Integer> mapa = new HashMap<>();
	
	// Constructor
	public PretrazivacDatoteka(String ekstenzija, Path putanjaPocetnogDirektorijuma, Path putanjaOdredisnogDirektorijuma){
		this.ekstenzija = ekstenzija;
		this.putanjaPocetnogDirektorijuma = putanjaPocetnogDirektorijuma;
		this.putanjaOdredisnogDirektorijuma = putanjaOdredisnogDirektorijuma;
	}
	
	@Override
	public FileVisitResult postVisitDirectory(Path putanja, IOException exc)throws IOException{
		return FileVisitResult.CONTINUE;
	}  
	
	@Override
	public FileVisitResult preVisitDirectory(Path putanja, BasicFileAttributes attrs)throws IOException{
		return FileVisitResult.CONTINUE;
	}
	
	@Override
	public FileVisitResult visitFile(Path putanja, BasicFileAttributes attrs)throws IOException{
		if(putanja.getFileName().toString().endsWith(this.ekstenzija)){
			this.listaPutanjaDatotekaSaOdgovarajucomEkstenzijom.add(putanja);
			
			if(mapa.containsKey(putanja)){
				int broj = mapa.get(putanja);
				broj++;
				mapa.put(putanja,broj);
			}else{
				mapa.put(putanja, 1);
			}
		}
		return FileVisitResult.CONTINUE;
	}
	
	@Override
	public FileVisitResult visitFileFailed(Path putanja, IOException ex)throws IOException{
		return FileVisitResult.CONTINUE;
	}
	
	void kopirajDatoteke(){
		for(var putanja : this.listaPutanjaDatotekaSaOdgovarajucomEkstenzijom){
			try{
				Path odredisnaPutanja = Paths.get(putanjaOdredisnogDirektorijuma.toString(), putanja.getFileName().toString());
				Files.copy(putanja, odredisnaPutanja);
			}catch(IOException ex){
				ex.printStackTrace();
			}
		}
	}
	
	void prikaziMapu(){
		for(Map.Entry<Path, Integer> mapaEntry : mapa.entrySet()){
			String kljucMape = mapaEntry.getKey().toString();
			String vrijednostKljucaMape = mapaEntry.getValue().toString();
			System.out.println(kljucMape + ", " + vrijednostKljucaMape);
		}
	}
	
	@Override
	public String toString(){
		return "Ekstenzija: " + this.ekstenzija + "\n" +
		"Pocetni dir: " + this.putanjaPocetnogDirektorijuma.toString() + "\n" +
		"Odredisni dir: " + this.putanjaOdredisnogDirektorijuma.toString() + "\n";
	}
}
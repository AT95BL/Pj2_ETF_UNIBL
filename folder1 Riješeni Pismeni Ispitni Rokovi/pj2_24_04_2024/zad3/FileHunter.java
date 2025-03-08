
import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class FileHunter implements FileVisitor<Path>{
	
	List<Path> listaPutanja = new ArrayList<>();
	
	Path putanjaPocetnogDirektorijuma = null;
	
	public static int ID=0;
	int id;
	
	public static int BROJAC_SKRIVENIH_FAJLOVA = 0;
	public static int BROJAC_VIDJLJIVIH_FAJLOVA = 0;
	
	// Constructor
	public FileHunter(Path putanjaPocetnogDirektorijuma){
		this.id = ++ID;
		this.putanjaPocetnogDirektorijuma = putanjaPocetnogDirektorijuma;
	}
	
	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)throws IOException{ 
		return FileVisitResult.CONTINUE; 
	}
	
	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException exc)throws IOException{ 
		return FileVisitResult.CONTINUE; 
	}
	
	@Override
	public FileVisitResult visitFile(Path dir, BasicFileAttributes attrs)throws IOException{ 
		
		if(Files.isHidden(dir)){
			listaPutanja.add(dir);
			BROJAC_SKRIVENIH_FAJLOVA++;
		
		}else{
			BROJAC_VIDJLJIVIH_FAJLOVA++;
		}
	
		return FileVisitResult.CONTINUE; 
	}
	
	@Override
	public FileVisitResult  visitFileFailed(Path file, IOException exc)throws IOException{ 
		return FileVisitResult.CONTINUE; 
	}
	
	public void upisiPutanjeUTxtDatoteku(){
		try(PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(putanjaPocetnogDirektorijuma + File.separator + "putanje.txt", true)))){
			for(var putanja : listaPutanja){
				printWriter.println(putanja);
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void upisiPodatkeUTxtDatoteku(){
		try(PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(putanjaPocetnogDirektorijuma + File.separator + "podaci.txt", true)))){
			
			printWriter.println("Ukupan broj pronadjenih datoteka: " + (BROJAC_SKRIVENIH_FAJLOVA + BROJAC_VIDJLJIVIH_FAJLOVA));
			printWriter.println("Ukupan broj korisniku vidjljivih datoteka: " + BROJAC_VIDJLJIVIH_FAJLOVA);
			printWriter.println("Ukupan broj korisniku skrivenih datoteka: " + BROJAC_SKRIVENIH_FAJLOVA);
			
			double procent = (double)BROJAC_SKRIVENIH_FAJLOVA/BROJAC_VIDJLJIVIH_FAJLOVA;
			printWriter.println("Procent: " + procent);
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
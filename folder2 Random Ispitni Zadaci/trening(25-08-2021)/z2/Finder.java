
import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.util.List;
import java.util.Scanner;
import java.awt.Desktop;

public class Finder implements FileVisitor<Path>{
	
	String trazeniPattern;
	Path pocetniDirektorijum;
	boolean pronadjeno=false;
	
	// Constructor
	public Finder(String trazeniPattern, Path pocetniDirektorijum){
		this.trazeniPattern=trazeniPattern;
		this.pocetniDirektorijum=pocetniDirektorijum;
	}
	
	public void find(Path path){
		
		if(path.getFileName().toString().toUpperCase().contains(this.trazeniPattern)){
			System.out.println("Pattern pronadjen u imenu datoteke " + path.getFileName().toString());
			pronadjeno=true;
		}
		
		if(path.getFileName().toString().endsWith(".java") || path.getFileName().toString().endsWith(".txt")){
			List<String> sveLinijeDatoteke=null;
			try{
				sveLinijeDatoteke=Files.readAllLines(path);
				
				for(int i=0; i < sveLinijeDatoteke.size(); i++){
					String tmp=sveLinijeDatoteke.get(i).toUpperCase();
					for(int index=-1;(index=tmp.indexOf(this.trazeniPattern,index+1))!=-1;)
					{
						System.out.println("Patern pronadjen  u fajlu:"+path+" u redu "+(i+1)+" pozicija"+index);
						pronadjeno=true;
					}
				}
			}catch(IOException ex){
				ex.printStackTrace();
			}
		}
		
		if (pronadjeno) {
			try {
				Desktop desktop = Desktop.getDesktop();
				desktop.open(new File(path.getParent().toString()));  // samo dodas '.getParent()' i onda otvara direktorijum gdje se nalazi fajl
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException exc)throws IOException{
		return FileVisitResult.CONTINUE;
	}
	
	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)throws IOException{
		return FileVisitResult.CONTINUE;
	}
	
	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException{
		find(file);
		
		if(this.pronadjeno){
				
		System.out.println("OPCIJA:");
		Scanner scanner=new Scanner(System.in);
		String opcija;
			
		while(true){
			opcija=scanner.nextLine();
			if("NASTAVAK".equals(opcija))
				return FileVisitResult.CONTINUE;
			else if("KRAJ".equals(opcija))
					return FileVisitResult.TERMINATE;
			else{
					System.out.println("Pogresna opcija");
						continue;
				}
			}	
		}
		return FileVisitResult.CONTINUE;
	}
	
	@Override
	public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException{
		return FileVisitResult.CONTINUE;
	}
}
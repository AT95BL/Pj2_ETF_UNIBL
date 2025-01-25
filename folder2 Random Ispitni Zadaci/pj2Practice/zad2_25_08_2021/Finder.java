
import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.util.List;
import java.awt.Desktop;
import java.util.Scanner;

public class Finder implements FileVisitor<Path>{
	
	Path rootDirektorijum;
	String trazeniPattern;
	boolean pronadjeno=false;
	
	Scanner scanner = new Scanner(System.in);
	
	// Constructor
	public Finder(Path rootDirektorijum, String trazeniPattern){
		this.rootDirektorijum = rootDirektorijum;
		this.trazeniPattern = trazeniPattern;
	}
	
	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException exc)throws IOException{
		return FileVisitResult.CONTINUE;
	}
	
	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes exc)throws IOException{
		return FileVisitResult.CONTINUE;
	}
	
	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)throws IOException{
		find(file);
		
		String opcija = "";
		
		while(true){
			opcija = scanner.nextLine();
			if("NASTAVAK".equalsIgnoreCase(opcija))
				return FileVisitResult.CONTINUE;
			else if("KRAJ".equalsIgnoreCase(opcija))
				return FileVisitResult.TERMINATE;
			else{
				System.out.println("Pogresna Opcija");
				continue;
			}
		}
	}
	
	@Override
	public FileVisitResult visitFileFailed(Path file, IOException exc)throws IOException{
		return FileVisitResult.CONTINUE;
	}
	
	public void find(Path path){
		
		if(path.getFileName().toString().endsWith(this.trazeniPattern) || path.getFileName().toString().endsWith(this.trazeniPattern)){
			System.out.println("Pattern pronadjen u imenu datoteke.." + path.getFileName().toString());
			this.pronadjeno = true;
		}
		
		if(path.getFileName().toString().endsWith(".txt") || path.getFileName().toString().endsWith(".java")){
			
			List<String> lines;
			
			try{
				
				lines = Files.readAllLines(path);
				
				for(int i=0; i < lines.size(); i++){
					String tmp = lines.get(i).toUpperCase();
					for(int index=-1; (index=tmp.indexOf(this.trazeniPattern, index+1))!=-1;){
						System.out.println("Pattern pronadjen u fajlu: " + path + " u redu: " +(i+1)+ " pozicija" + index);
						pronadjeno=true;
					}
				}
				
			}catch(IOException ex){
				ex.printStackTrace();
			}
			
			if(pronadjeno){
				try{
					Desktop desktop = Desktop.getDesktop();
					desktop.edit(new File(path.toString()));
				}
				catch(IOException ex){
					ex.printStackTrace();
				}
			}
		}
	}
}

import java.util.Scanner;
import java.io.*;
import java.nio.file.*;

public class Main{
	public static void main(String[] args){
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Unesite putanju pocetnog direktorijuma: ");
		String line = scanner.nextLine();
		Path putanjaDoPocetnogDirektorijuma = Paths.get(line);
		
		System.out.println("Unesite ekstenziju: ");
		String ekstenzija = scanner.nextLine();
		
		System.out.println("Unesite putanju destinacionog direktorijuma: ");
		line = scanner.nextLine();
		Path putanjaDoDestinacionogDirektorijuma = Paths.get(line);
		
		FileFinder fileFinder = new FileFinder(putanjaDoPocetnogDirektorijuma, ekstenzija, putanjaDoDestinacionogDirektorijuma);
		System.out.println(fileFinder);
		
		try{
			Files.walkFileTree(putanjaDoPocetnogDirektorijuma, fileFinder);
		}catch(IOException ex){
			ex.printStackTrace();
		}
		
		fileFinder.copyAllFiles();
		fileFinder.printMap();
	}
}
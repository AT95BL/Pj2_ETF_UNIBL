
import java.io.*;
import java.nio.file.*;
import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		
		Scanner scanner = new Scanner(System.in);
		
		String trazeniPattern="";
		System.out.println("Unesite Trazeni Pattern: ");
		trazeniPattern=scanner.nextLine();
		
		String pocetniDirektorijum="";
		System.out.println("Unesite Putanju Pocetnog Direktorijuma: ");
		pocetniDirektorijum=scanner.nextLine();
		Path root=Paths.get(pocetniDirektorijum);
		
		System.out.println("Pocinje pretraga: " + "\n" + 
		"Pattern(" + trazeniPattern + ")" + "\n" +
		"root(" + pocetniDirektorijum + ")");
		
		Finder finder=new Finder(trazeniPattern, root);
		try{
			Files.walkFileTree(root, finder);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
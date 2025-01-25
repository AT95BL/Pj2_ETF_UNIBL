
import java.util.*;
import java.io.*;
import java.nio.file.*;

public class Main{
	public static void main(String[] args){
		
		Scanner scanner = new Scanner(System.in);
		String line = "";
		String tekstZaPretragu = "";
		
		Path putanjaDoPocetnogFoldera = null;
		
		System.out.println("Unesite putanju pocetnog foldera: ");
		line = scanner.nextLine();
		putanjaDoPocetnogFoldera = Paths.get(line);
		
		System.out.println("Unesite tekst za pretragu: ");
		tekstZaPretragu = scanner.nextLine();
		
		Pretraga pretraga = new Pretraga(putanjaDoPocetnogFoldera, tekstZaPretragu);
		try{
			Files.walkFileTree(putanjaDoPocetnogFoldera, pretraga);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
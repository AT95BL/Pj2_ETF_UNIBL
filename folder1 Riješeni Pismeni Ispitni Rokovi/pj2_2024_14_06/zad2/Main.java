
import java.util.Scanner;
import java.io.*;
import java.nio.file.*;

public class Main{
	public static void main(String[] args){
		
		Scanner scanner = new Scanner(System.in);
		String line = "";
		
		System.out.println("Unesite putanju pocetnog direktorijuma: ");
		line = scanner.nextLine();
		Path putanjaPocetnogDirektorijuma = Paths.get(line);
		
		System.out.println("Unesite duzinu rijeci: ");
		int duzinaRijeci = scanner.nextInt();
		
		BrojacRijeci brojacRijeci = new BrojacRijeci(putanjaPocetnogDirektorijuma, duzinaRijeci);
		
		try{
			Files.walkFileTree(putanjaPocetnogDirektorijuma, brojacRijeci);
		}catch(Exception ex){
			System.err.println(ex);
		}
		
		brojacRijeci.printResult();
	}
}
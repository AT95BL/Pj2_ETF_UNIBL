
import java.util.Scanner;
import java.nio.file.*;
import java.io.*;

public class Main{
	
	public static void main(String[] args){
		
		String linijaTeksta = " ";
		String ekstenzija = " ";
		Scanner scanner = new Scanner(System.in);
		Path putanjaPocetnogDirektorijuma = null;
		Path putanjaOdredisnogDirektorijuma = null;
		
		System.out.println("Unesite string-ekstenziju datoteke: ");
		ekstenzija = scanner.nextLine();
		System.out.println("Unesite string-putanju pocetnog direktorijuma: ");
		linijaTeksta = scanner.nextLine();
		putanjaPocetnogDirektorijuma = Paths.get(linijaTeksta);
		System.out.println("Unesite string-putanju odredisnog direktorijuma: ");
		linijaTeksta = scanner.nextLine();
		putanjaOdredisnogDirektorijuma = Paths.get(linijaTeksta);
		
		PretrazivacDatoteka pretrazivacDatoteka = new PretrazivacDatoteka(ekstenzija, putanjaPocetnogDirektorijuma, putanjaOdredisnogDirektorijuma);
		System.out.println(pretrazivacDatoteka);
		
		try{
			Files.walkFileTree(putanjaPocetnogDirektorijuma, pretrazivacDatoteka);
		}catch(IOException ex){
			ex.printStackTrace();
		}
		
		pretrazivacDatoteka.kopirajDatoteke();
		pretrazivacDatoteka.prikaziMapu();
	}
}
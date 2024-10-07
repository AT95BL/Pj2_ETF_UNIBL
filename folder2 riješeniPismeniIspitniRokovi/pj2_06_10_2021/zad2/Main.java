
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.io.*;
import java.nio.file.*;

public class Main{
	public static void main(String[] args){
		Scanner scanner=new Scanner(System.in);
		ArrayList<String> rijeci=new ArrayList<>();
		ArrayList<Path> putanje=new ArrayList<>();
		String line="";
		Path putanja=null;
		int n;
		HashMap<String, String> rijecnik=new HashMap<>();
		
		System.out.println("Testiranje metode 'pronadjiRijeciUFajlovima': ");
		do{
			System.out.println("n= ");
			n=scanner.nextInt();
		}while(n < 0 && n >5);
		while(n-- != 0){
			line=scanner.nextLine();
			rijeci.add(line);
		}
		while(true){
			System.out.println("Unesite putanju ili kucajte 'IZLAZ': ");
			line=scanner.nextLine();
			if("IZLAZ".equalsIgnoreCase(line)){
				break;
			}
			putanja=Paths.get(line);
			putanje.add(putanja);
		}
		RadSaFajlovima.pronadjiRijeciUFajlovima(rijeci, putanje.toArray(new Path[0]));
		
		System.out.println("Testiranje metode 'brojanjeRijeci', unesite putanju: ");
		line=scanner.nextLine();
		putanja=Paths.get(line); // mozda mozes putanja=Paths.get(line.nextLine()); ??
		RadSaFajlovima.prebrojRijeci(putanja);
		
		System.out.println("Testiranje metode 'zamjeniRijeciUFajlu', unesite putanju: ");
		line=scanner.nextLine();
		putanja=Paths.get(line);
		String kljuc="";
		String vrijednost="";
		do{
			System.out.println("n= ");
			n=scanner.nextInt();
		}while(n < 0 && n >5);
		while(n-- != 0){
			System.out.println("Kljuc: ");
			kljuc=scanner.nextLine();
			System.out.println("Vrijednost: ");
			vrijednost=scanner.nextLine();
			rijecnik.put(kljuc, vrijednost);
		}
		RadSaFajlovima.zamjeniRijeciUFajlu(putanja, rijecnik);
	}
}
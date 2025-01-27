
import java.util.*;
import java.io.*;
import java.nio.file.*;

public class Main{
	
	public static void main(String[] args){
		
		Scanner scanner = new Scanner(System.in);
		
		String rijec = "";
		String ekstenzija = "";
		String stringPocetnogDirektorijuma = "";
		
		System.out.println("Unesite rijec za pretragu: ");
		rijec = scanner.nextLine();
		
		System.out.println("Unesite ekstenziju za pretragu: ");
		ekstenzija = scanner.nextLine();
		
		System.out.println("Unesite putanju pocetnog direktorijuma: ");
		stringPocetnogDirektorijuma = scanner.nextLine();
		Path putanjaPocetnogDirektorijuma = Paths.get(stringPocetnogDirektorijuma);
		
		Pretrazivac pretrazivac = new Pretrazivac(rijec, ekstenzija, putanjaPocetnogDirektorijuma);
		
		try{
			Files.walkFileTree(putanjaPocetnogDirektorijuma, pretrazivac);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		System.out.println(pretrazivac);
	}
}
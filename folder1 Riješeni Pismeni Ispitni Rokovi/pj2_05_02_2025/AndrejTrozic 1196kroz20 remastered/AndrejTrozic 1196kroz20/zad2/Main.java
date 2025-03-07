
import java.util.*;
import java.io.*;
import java.util.*;
import java.nio.file.*;

public class Main{
	public static void main(String[] args){
		
		Scanner scanner = new Scanner(System.in);
		
		String stringPutanjaPocetnogDirektorijuma = "";
		System.out.println("Unesite putanju pocetnog direktoprijuma: ");
		stringPutanjaPocetnogDirektorijuma = scanner.nextLine();
		Path putanjaPocetnogDirektorijuma = Paths.get(stringPutanjaPocetnogDirektorijuma);
		
		String stringEkstenzija = "";
		System.out.println("Unesite ekstenziju: ");
		stringEkstenzija = scanner.nextLine();
		
		Pretrazivac pretrazivac = new Pretrazivac(putanjaPocetnogDirektorijuma, stringEkstenzija);
		
		try{
			Files.walkFileTree(putanjaPocetnogDirektorijuma, pretrazivac);
			pretrazivac.print();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}

import java.util.Scanner;
import java.nio.file.*;
import java.io.IOException;

public class Main
{
	public static void main(String[]args)throws IOException
	{
		Scanner scanner=new Scanner(System.in);
		System.out.println("Unesite string za pretragu:");
		String pattern=scanner.nextLine();
		System.out.println("Za nastavak(NASTAVAK),za kraj(KRAJ)!!");
		Path path=Paths.get("C:\\Users\\Korisnik.DESKTOP-JVOQTMK\\Desktop\\pj2_25_08_2021\\zad2\\test");
		Finder finder=new Finder(path,pattern);
		Files.walkFileTree(path,finder);		
	}
}
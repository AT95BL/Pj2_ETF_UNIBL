
import java.nio.file.*;
import java.io.IOException;
import java.util.Scanner;

public class Main
{
	public static void main(String[]args)throws IOException
	{
		Scanner scanner = new Scanner(System.in);
		String ekstenzija = "";
		String line = "";

		System.out.println("Unesite pocetnu putanju: ");
		line = scanner.nextLine();
		Path pocetnaPutanja = Paths.get(line);

		System.out.println("Unesite destinacionu putanju: ");
		line = scanner.nextLine();
		Path destinacionaPutanja = Paths.get(line);

		System.out.println("Unesite ekstenziju: ");
		ekstenzija = scanner.nextLine();

		Finder finder=new Finder(ekstenzija,destinacionaPutanja);
		Files.walkFileTree(pocetnaPutanja,finder);							//	početni direktorijum, implementacija FileVisitor interface-a 
		System.out.println(finder.getNumOfMatchedFiles());
		finder.copyAllFiles();
	}
}

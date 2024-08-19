
import java.util.Scanner;
import java.nio.file.*;
import java.io.*;

public class Main{
	
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Unesite putanju direktorijuma od kojeg pocinje pretraga: ");
            String pocetniDirektorijum = scanner.nextLine();
            Path path = Paths.get(pocetniDirektorijum);

            System.out.println("Unesite tekstualni pattern: ");
            String trazeniPattern = scanner.nextLine();

            Finder finder = new Finder(path, trazeniPattern);

            Files.walkFileTree(path, finder);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
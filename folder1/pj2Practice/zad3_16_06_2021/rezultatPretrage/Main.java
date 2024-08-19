import java.nio.file.*;
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Unos putanje direktorijuma od kojeg počinje pretraga
        System.out.println("Unesite putanju direktorijuma od kojeg pocinje pretraga: ");
        String pocetniDirektorijum = scanner.nextLine();

        // Unos putanje direktorijuma u kojem ćemo čuvati rezultate pretrage
        System.out.println("Unesite putanju direktorijuma u kojem ćemo čuvati rezultate pretrage: ");
        String ciljniDirektorijum = scanner.nextLine();

        // Unos ekstenzije za pretragu
        System.out.println("Unesite ekstenziju za pretragu: ");
        String ekstenzija = scanner.nextLine();

        // Kreiranje Finder objekta
        Finder finder = new Finder(ciljniDirektorijum, ekstenzija);

        try {
            // Pokretanje pretrage
            Files.walkFileTree(Paths.get(pocetniDirektorijum), finder);

            // Ispis rezultata pretrage
            System.out.println("Broj pronađenih fajlova: " + finder.getNumOfMatchedFiles());
            for (Path path : finder.pronadjeniFajlovi) {
                System.out.println(path);
            }

            // Kopiranje fajlova u ciljni direktorijum
            finder.kopirajFajlove();
        } catch (IOException e) {
            System.err.println("Greška prilikom pretrage direktorijuma: " + e.getMessage());
        }

        scanner.close();
    }
}

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.nio.file.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static final int BROJ_VRSTA = 10;
    public static final int BROJ_KOLONA = 20;
    public static Object[][] mapa = new Object[BROJ_VRSTA][BROJ_KOLONA];

    List<Knjiga> listaKnjiga = new ArrayList<>();
    List<Korisnik> listaKorisnika = new ArrayList<>();
	
    Path putanja;
	
    // Konstruktor sa ispravljenim imenom i logikom
    public Main(String putanja) {
        this.putanja = Paths.get(putanja);
    }
	
    public List<Knjiga> generisiKnjige() {
        for (int i = 0; i < 30; i++) {
            Knjiga knjiga = new Knjiga();
            listaKnjiga.add(knjiga);
        }
        return listaKnjiga;
    }

    public List<Korisnik> generisiKorisnike() {
        for (int i = 0; i < 10; i++) { // Fiksiran broj korisnika na 10
            Korisnik korisnik = new Korisnik();
            listaKorisnika.add(korisnik);
        }
        return listaKorisnika;
    }

    public void pokreniSimulaciju() {
        for (var korisnik : listaKorisnika) {
            korisnik.start();
        }
    }

    public static void registrujKorisnikaUFajl(Korisnik korisnik, Path putanja) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String vremeRegistracije = dateFormat.format(new Date());

        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(putanja.toString(), true)))) {
            writer.println(korisnik + " - Registrovan: " + vremeRegistracije);
        } catch (IOException e) {
            System.err.println("Greška pri pisanju u fajl: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("Unesite putanju za zapisivanje podataka:");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        scanner.close();

        Main app = new Main(line);

        app.generisiKnjige();
        app.generisiKorisnike();
        app.pokreniSimulaciju();
    }
}

import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.nio.file.*;

public class Korisnik extends Thread {
    static int ID = 0;
    int id;
    String imeIPrezime;
    int godineStarosti;
    String oblastInteresovanja;
    int brojClanskeKarte;
    int koordinataX;
    int koordinataY;
    Random random = new Random();
    List<Knjiga> listaKnjiga = new ArrayList<>();

    // Konstruktor
    public Korisnik() {
        this.id = ++ID;
        this.imeIPrezime = "Korisnik" + this.id;
        this.godineStarosti = random.nextInt(86) + 5; // Popravljeno: 5-90 godina

        if (this.godineStarosti <= 12) {
            this.oblastInteresovanja = "KNJIGE ZA DJECU";
        } else {
            this.oblastInteresovanja = random.nextBoolean() ? "BELETRISTIKA" : "STRUCNA LITERATURA";
        }

        this.brojClanskeKarte = this.godineStarosti + 5;

        // Postavi na Mapu
        do {
            this.koordinataX = random.nextInt(Main.BROJ_VRSTA);
            this.koordinataY = random.nextInt(Main.BROJ_KOLONA);
        } while (Main.mapa[this.koordinataX][this.koordinataY] != null);

        Main.mapa[this.koordinataX][this.koordinataY] = this;
    }

    public void uzmiKnjigu(Knjiga knjiga) {
        this.listaKnjiga.add(knjiga);
    }

    @Override
    public String toString() {
        return "{" + this.imeIPrezime + ", " + this.godineStarosti + ", " + this.oblastInteresovanja + ", " + this.brojClanskeKarte + "}";
    }

    @Override
    public void run() {
        while (this.koordinataX < Main.BROJ_KOLONA - 1) {
            System.out.println(this);

            if (Main.mapa[this.koordinataX + 1][this.koordinataY] instanceof Knjiga) {
                Knjiga knjiga = (Knjiga) Main.mapa[this.koordinataX + 1][this.koordinataY];
                this.uzmiKnjigu(knjiga);
                Main.mapa[this.koordinataX + 1][this.koordinataY] = null;
            }

            this.koordinataX++;
            Main.mapa[this.koordinataX][this.koordinataY] = this;
            Main.mapa[this.koordinataX - 1][this.koordinataY] = null;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

        // Upis u fajl nakon završetka kretanja
        Path putanja = Main.mapa.length > 0 ? Paths.get("BIBLIOTEKA-" + System.currentTimeMillis() + ".txt") : null;
        if (putanja != null) {
            Main.registrujKorisnikaUFajl(this, putanja);
        }
    }
}

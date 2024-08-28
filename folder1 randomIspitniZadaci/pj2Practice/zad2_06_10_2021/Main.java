
import java.nio.file.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Test podaci
        ArrayList<String> kljucneRijeci = new ArrayList<>(Arrays.asList("ključna", "riječ", "test"));
        Path[] putanje = {Paths.get("prvi.txt"), Paths.get("drugi.txt")};

        // Prva metoda: Pronalaženje ključnih riječi u datotekama
        RadSaFajlovima.pronalazenjeKljucnihRijeciUDatotekama(kljucneRijeci, putanje);

        // Druga metoda: Prebrojavanje riječi u fajlu
        Path putanjaZaBrojanje = Paths.get("prvi.txt");
        RadSaFajlovima.prebrojavanjeRijeciUDatoteci(putanjaZaBrojanje);

        // Treća metoda: Zamjena riječi u fajlu
        HashMap<String, String> zamjenaRijeci = new HashMap<>();
        zamjenaRijeci.put("staraRiječ", "novaRiječ");
        zamjenaRijeci.put("test", "provjera");

        Path putanjaZaZamjenu = Paths.get("drugi.txt");
        RadSaFajlovima.zamjeniRijeciUDatoteci(putanjaZaZamjenu, zamjenaRijeci);
    }
}


import java.nio.file.*;
import java.util.*;
import java.io.*;

public class RadSaFajlovima {

    public static void pronalazenjeKljucnihRijeciUDatotekama(ArrayList<String> trazeneKljucneRijeci, Path... putanje) {
        for (var putanja : putanje) {
            try {
                String nazivFajla = putanja.getFileName().toString() + ".search.txt";
                Path parent = putanja.getParent();
                String putanjaZaPisanje = (parent != null ? parent.toString() + File.separator : "") + nazivFajla;

                PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(putanjaZaPisanje)));

                List<String> sveLinijeDatoteke = Files.readAllLines(putanja);
                for (var jednaLinijaDatoteke : sveLinijeDatoteke) {                           // line-by-line prolazimo kroz sveLinijeDatoteke..
                    var rijeciJedneLinijeDatoteke = jednaLinijaDatoteke.split("\\W+");  // ZAMAPTI '.split("\\W+");'
                    for (var rijecJedneLinijeDatoteke : rijeciJedneLinijeDatoteke) {
                        for (var trazenaRijec : trazeneKljucneRijeci) {
                            if (rijecJedneLinijeDatoteke.equalsIgnoreCase(trazenaRijec)) {
                                writer.println(jednaLinijaDatoteke);
                                break;
                            }
                        }
                    }
                }

                writer.flush();
                writer.close();
            } catch (IOException ex) {                               //  ZAMAPTI!! KAD RADIŠ SA I/O -OČEKUJEŠ MOGUĆE IOException SITUACIJE!!
                ex.printStackTrace();
                return;
            }
        }
    }

    public static void prebrojavanjeRijeciUDatoteci(Path putanja) {
        Map<String, Integer> mapa = new HashMap<>();
        try {
            List<String> sveLinijeDatoteke = Files.readAllLines(putanja);
            for (var jednaLinijaDatoteke : sveLinijeDatoteke) {
                var rijeciJedneLinijeDatoteke = jednaLinijaDatoteke.split("\\W+");
                for (var rijec : rijeciJedneLinijeDatoteke) {
                    if (mapa.containsKey(rijec)) {
                        mapa.put(rijec, mapa.get(rijec) + 1);
                    } else {
                        mapa.put(rijec, 1);
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            return;
        }

        System.out.println("Rijeci u datoteci i ponavljanja: ");
        mapa.entrySet().forEach((s) -> {
            System.out.println(s.getKey() + "---" + s.getValue());
        });
    }

    public static void zamjeniRijeciUDatoteci(Path path, HashMap<String, String> rijecnik) {
        try {
            List<String> sveLinijeDatoteke = Files.readAllLines(path);
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(path.toString())));
            for (var jednaLinijaDatoteke : sveLinijeDatoteke) {
                var rijeciJedneLinijeDatoteke = jednaLinijaDatoteke.split("\\W+");
                String novaLinijaDatoteke = new String(jednaLinijaDatoteke);
                for (var rijec : rijeciJedneLinijeDatoteke) {
                    if (rijecnik.containsKey(rijec)) {
                        novaLinijaDatoteke = novaLinijaDatoteke.replaceAll("\\b" + rijec + "\\b", rijecnik.get(rijec));
                    }
                }
                writer.println(novaLinijaDatoteke);
            }
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
            return;
        }
    }
}

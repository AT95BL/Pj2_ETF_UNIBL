import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class GrupaKnjiga {

    private Set<Knjiga> knjige = new HashSet<>();

    // Constructor, methods to add books, etc.
    public GrupaKnjiga() {
        knjige = new HashSet<>();
    }

    public GrupaKnjiga(Set<Knjiga> knjige) {
        this.knjige = knjige;
    }

    public void dodajKnjigu(Knjiga knjiga) {
        knjige.add(knjiga);
    }

    public void dodajKnjige(Set<Knjiga> noveKnjige) {
        knjige.addAll(noveKnjige);
    }

    public Set<Knjiga> getKnjige() {
        return this.knjige;
    }

    public static void main(String[] args) {

        GrupaKnjiga prvaGrupa = new GrupaKnjiga();
        GrupaKnjiga drugaGrupa = new GrupaKnjiga();

        for (int i = 0; i < 20; i++) {
            Knjiga knjiga = new Knjiga("naslov" + i, "ime" + i + "prezime" + i, 1995 + i, Zanr.values()[i % 4]);
            prvaGrupa.dodajKnjigu(knjiga);
        }

        for (int i = 0; i < 50; i++) {
            Knjiga knjiga = new Knjiga("naslov" + i, "ime" + i + "prezime" + i, 1995 + i, Zanr.values()[i % 4]);
            drugaGrupa.dodajKnjigu(knjiga);
        }

        // Spajanje grupa knjiga
        prvaGrupa.dodajKnjige(drugaGrupa.getKnjige());
        drugaGrupa.getKnjige().clear();

        // Filtiranje grupe knjiga
        prvaGrupa.getKnjige().stream()   
                .collect(Collectors.groupingBy(Knjiga::getZanr))
                .forEach((zanr, knjige) -> {
                    System.out.println("Žanr: " + zanr);
                    knjige.forEach(System.out::println);
                });

        // Sortiranje grupe knjiga po godini izdavanja
        prvaGrupa.getKnjige().stream()
                .sorted(Comparator.comparingInt(Knjiga::getGodinaIzdavanja)) // znači, kao argument omparingInt mi treba neki int..
                .forEach(System.out::println);

        // Sumiranje godina izdavanja svih knjiga iz grupe žanra "putopis"
        int sum = prvaGrupa.getKnjige().stream()
                .filter(knjiga -> knjiga.getZanr() == Zanr.PUTOVANJE)
                .mapToInt(Knjiga::getGodinaIzdavanja)
                .sum();

        System.out.println("Suma godina izdavanja putopisa: " + sum);

        // Prikazati knjigu sa najkraćim naslovom i sa najdužim naslovom
        prvaGrupa.getKnjige().stream()
                .min(Comparator.comparingInt(knjiga -> knjiga.getNaslov().length()))
                .ifPresent(knjiga -> System.out.println("Najkraći naslov: " + knjiga.getNaslov()));

        prvaGrupa.getKnjige().stream()
                .max(Comparator.comparingInt(knjiga -> knjiga.getNaslov().length()))
                .ifPresent(knjiga -> System.out.println("Najduži naslov: " + knjiga.getNaslov()));
    }
}

/*
 *  Iz ovog primjera zapamti:
 *  -argument(oblik argumenta..) metode Collectors.groupingBy()
 *  -argument(oblik argumenta..) metode sorted()
 *  -argument(oblik argumenta..) metode Comparator.comparingInt()
 *  -argument(oblik argumenta..) metode filter()
 *  -argument(oblik argumenta .) metode mapToInt()
 *  -argument(oblik argumenta..) metoda min() i max()
 *  -argument(oblik argumenta..) metode ifPresent()
 * 
 *  -Napominjem da smo stream pravili od polazne HashSet<>() kolekcije!!
 *  
 *  Znači, što se Java Stream API-ja tiče, zamisli kakvu polaznu kolekciju imaš,
 *  zamisli šta sa njom želiš da napraviš tj. kakav stream i kako da ga obradiš i u skladu
 *  sa tim mislima redom pozivaj metode iz Java Stream API-ja..
 */

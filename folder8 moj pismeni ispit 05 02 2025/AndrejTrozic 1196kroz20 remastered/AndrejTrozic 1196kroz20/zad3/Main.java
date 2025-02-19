
import java.util.*;
import java.util.stream.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main{
	
	public static void main(String[] args){
		Set<Knjiga> prvaGrupa = new HashSet<>();
		Set<Knjiga> drugaGrupa = new HashSet<>();
		
		Random random = new Random();
		
		for(int i=0; i < 20; i++){
			
			Knjiga knjiga1 = new Knjiga("naslov"+i, "autor"+i, i+1990, Zanr.FIKCIJA, 100+i);
			Knjiga knjiga2 = new Knjiga("naslov"+i, "autor"+i, i+1990, Zanr.NAUKA, 100+i);
			Knjiga knjiga3 = new Knjiga("naslov"+i, "autor"+i, i+1990, Zanr.ISTORIJA, 100+i);
			prvaGrupa.add(knjiga1);
			prvaGrupa.add(knjiga2);
			prvaGrupa.add(knjiga3);
			
			Knjiga knjiga4 = new Knjiga("naslov"+i, "autor"+i, i+2002, Zanr.FIKCIJA, 100+i);
			Knjiga knjiga5 = new Knjiga("naslov"+i, "autor"+i, i+2002, Zanr.NAUKA, 100+i);
			Knjiga knjiga6 = new Knjiga("naslov"+i, "autor"+i, i+2002, Zanr.ISTORIJA, 100+i);
			drugaGrupa.add(knjiga4);
			drugaGrupa.add(knjiga5);
			drugaGrupa.add(knjiga5);
		}
		
		System.out.println("Prva Grupa: ");
		prvaGrupa.stream().forEach(System.out::println);

		System.out.println("Druga Grupa: ");
		drugaGrupa.stream().forEach(System.out::println);
		
			/*
			* 	Spojiti dvije grupe knjiga tako da se sve knjige iz druge grupe dodaju u prvu grupu, a druga grupa
			* 	postane prazna.
			*/
		System.out.println("Spajanje grupa knjiga..");
		prvaGrupa.addAll(drugaGrupa);

		drugaGrupa.clear();

		System.out.println("Prva Grupa(Nakon spajanja..): ");
		prvaGrupa.stream().forEach(System.out::println);

			/*
			*  Korišćenjem Predicate<Knjiga> interfejsa filtrirati knjige iz grupe(npr. s godinom izdanja posle 2010)
			*  i zatim ih grupisati po žanru. Grupe ispisati na konzoli.
			*/
		Predicate<Knjiga> predikatKnjige = knjiga -> knjiga.getGodinaIzdanja() > 2010;

		System.out.println("Knjige nakon 2010..");
		prvaGrupa.stream().filter(predikatKnjige).forEach(System.out::println);

		prvaGrupa.stream().collect(Collectors.groupingBy(Knjiga::getZanr)).forEach((zanr, knjige)->{
			System.out.println("Zanr: " + zanr);
			knjige.forEach(System.out::println);
		});

			/*
			* 	Sortirati knjige u opadajućem redoslijedu po broju stranica i ispisati ih na konzoli.
			*/
		System.out.println("Sortiranje..");
		prvaGrupa.stream().sorted(Comparator.comparingInt(Knjiga::getGodinaIzdanja)).forEach(System.out::println);

			/*
			* 	Korišćenjem Predicate<Knjiga> interfejsa izračunati ukupan broj stranica svih knjiga žanra
			*  NAUKA sa neparnom godinom izdanja.
			*/
		Function<Knjiga,Integer> funkcija = (knjiga)->{
			if(knjiga.getZanr() == Zanr.NAUKA && (knjiga.getGodinaIzdanja() % 2 != 0)){
				return knjiga.getGodinaIzdanja();
			}
			return 0;
		};

		Function<Knjiga, Integer> getGodinaIzdanjaFunkcija = Knjiga::getGodinaIzdanja;
        int suma = prvaGrupa.stream()
                .filter(knjiga -> knjiga.getZanr() == Zanr.NAUKA)
                .filter(knjiga -> getGodinaIzdanjaFunkcija.apply(knjiga) % 2 != 0)
                .mapToInt(Knjiga::getBrojStranica)
                .sum();
        System.out.println("Ukupan broj stranica knjiga nauke sa neparnom godinom izdanja: " + suma);


			/*
			* 	Prikazati knjigu sa najmanje stranica, najviše stranica i najbližu prosječnom broju stranica u grupi.
			*/
		// Izračun prosječnog broja stranica	--POZIV METODE 'average()' !!!
        double prosjecanBrojStranica = prvaGrupa.stream()
                .mapToInt(Knjiga::getBrojStranica)
                .average()
                .orElse(0); // Vraćamo 0 ako je grupa prazna

        // Knjiga sa najmanje stranica
        Knjiga najmanjeStranica = prvaGrupa.stream()
                .min(Comparator.comparingInt(Knjiga::getBrojStranica))
                .orElse(null); // Vraćamo null ako je grupa prazna

        // Knjiga sa najviše stranica
        Knjiga najviseStranica = prvaGrupa.stream()
                .max(Comparator.comparingInt(Knjiga::getBrojStranica))
                .orElse(null); // Vraćamo null ako je grupa prazna

        // Knjiga najbliža prosjeku
        Knjiga najblizaProsjeku = prvaGrupa.stream()
                .min(Comparator.comparingDouble(knjiga -> 
                        Math.abs(knjiga.getBrojStranica() - prosjecanBrojStranica)))
                .orElse(null); // Vraćamo null ako je grupa prazna

        // Ispis rezultata
        System.out.println("Prosječan broj stranica: " + prosjecanBrojStranica);

        if (najmanjeStranica != null) {
            System.out.println("Knjiga sa najmanje stranica: " + najmanjeStranica);
        } else {
            System.out.println("Nema knjiga u grupi.");
        }

        if (najviseStranica != null) {
            System.out.println("Knjiga sa najviše stranica: " + najviseStranica);
        } else {
            System.out.println("Nema knjiga u grupi.");
        }

        if (najblizaProsjeku != null) {
            System.out.println("Knjiga najbliža prosjeku: " + najblizaProsjeku);
        } else {
            System.out.println("Nema knjiga u grupi.");
        }
	}
}
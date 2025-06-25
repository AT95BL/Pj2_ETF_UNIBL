
import java.util.*;
import java.util.function.*;

public class Main{
	
	static final int UKUPAN_BROJ_PROIZVODA = 50;
	
	public static void main(String[] args){
		
		Scanner scanner = new Scanner(System.in);
		int pocetniIndeks = 0;
		int poslednjiIndeks = UKUPAN_BROJ_PROIZVODA;
		
		List<Proizvod> listaProizvoda = new ArrayList<>();
		List<Function> listaFunkcija = new ArrayList<>();
		
		for(int i=0; i < UKUPAN_BROJ_PROIZVODA; i++){
			listaProizvoda.add(new Proizvod());
		}
		
		Function<Proizvod, String> funkcija1 = (proizvod) -> {
			return proizvod.naziv;
		};
		
		Function<Proizvod, String> funkcija2 = (proizvod) -> {
			String res = "";
			return res + proizvod.cijena;
		};
		
		Function<Proizvod, String> funkcija3 = (proizvod) -> {
			String res = "";
			return res + proizvod.kolicina;
		};
		
		listaFunkcija.add(funkcija1);
		listaFunkcija.add(funkcija2);
		listaFunkcija.add(funkcija3);
		
		metoda(pocetniIndeks, poslednjiIndeks, listaProizvoda, listaFunkcija);
	}
	
	public static void metoda(int pocetniIndeks, int poslednjiIndeks, List<Proizvod> listaProizvoda, List<Function> listaFunkcija){
		
		for(int i=pocetniIndeks; i < poslednjiIndeks; i++){
			
			Proizvod proizvod = listaProizvoda.get(i);
			for(int j=0; j < listaFunkcija.size(); j++){
				
				Function<Proizvod, String> funkcija = listaFunkcija.get(j);
				System.out.println(funkcija.apply(proizvod));
			}
		}
	}
}
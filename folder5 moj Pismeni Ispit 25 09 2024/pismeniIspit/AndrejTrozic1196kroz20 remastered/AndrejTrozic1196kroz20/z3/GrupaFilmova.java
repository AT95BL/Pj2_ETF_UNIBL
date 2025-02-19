
import java.util.Set;
import java.util.HashSet;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.*;

public class GrupaFilmova{
	Set<Film> filmovi = new HashSet<>();
	
	public void dodajFilm(Film f){
		this.filmovi.add(f);
	}
	
	public static void main(String[] args){
		GrupaFilmova prvaGrupa = new GrupaFilmova();
		GrupaFilmova drugaGrupa = new GrupaFilmova();
		
		System.out.println("Dodavanje Filmova:");
		for(int i=0; i < 20; i++){
			prvaGrupa.dodajFilm(new Film("nazivFilma"+i, "reditelj"+i, 1990+i, Zanr.values()[i%4]));
			drugaGrupa.dodajFilm(new Film("nazivFilma"+i+20, "reditelj"+i+20, 1990+i, Zanr.values()[i%4]));
		}
		System.out.println("Prva Grupa Filmova: ");
		prvaGrupa.filmovi.stream().forEach(System.out::println);
		System.out.println("Druga Grupa Filmova: ");
		drugaGrupa.filmovi.stream().forEach(System.out::println);
		
		System.out.println("Spajanje Grupa Filmova: ");
		prvaGrupa.filmovi.addAll(drugaGrupa.filmovi);
		drugaGrupa.filmovi.clear();
		prvaGrupa.filmovi.stream().forEach(System.out::println);
		
		prvaGrupa.filmovi.stream()
						.collect(Collectors.groupingBy(Film::getZanr))
						.forEach((zanr, filmovi)->{
							System.out.println(zanr); 
							filmovi.forEach(System.out::println);
							});
		
		prvaGrupa.filmovi.stream().sorted(Comparator.comparingInt(Film::getGodinaIzdavanja))
						.forEach(System.out::println);
		
		int suma = prvaGrupa.filmovi.stream().filter((f)-> f.zanr == Zanr.DOKUMENTARAC && f.godinaIzdavanja % 5 == 0).mapToInt(Film::getGodinaIzdavanja).sum();
		System.out.println("Suma: " + suma);
		
		prvaGrupa.filmovi.stream().min(Comparator.comparingInt(Film::getNazivFilmaLength)).ifPresent(f->{System.out.println(f.nazivFilma);});
		prvaGrupa.filmovi.stream().max(Comparator.comparingInt(Film::getNazivFilmaLength)).ifPresent(f->{System.out.println(f.nazivFilma);});
	}
}

import java.util.*;
import java.util.stream.*;

public class Main{
	
	public static void main(String[] args){
		
		Biblioteka biblioteka = new Biblioteka();
		System.out.println(biblioteka);
		
		//	1
		biblioteka.listaSekcija.stream().forEach( sekcija -> {
			int brojKnjigaUSekciji = sekcija.listaPolica.stream().mapToInt(polica -> polica.listaKnjiga.size()).sum();
			System.out.println("Sekcija: " + sekcija.id + ", broj knjiga: " + brojKnjigaUSekciji);
		});
		
		int ukupanBrojKnjiga = biblioteka.listaSekcija.stream().flatMap(sekcija -> sekcija.listaPolica.stream())
								.mapToInt(polica -> polica.listaKnjiga.size()).sum();
								
		System.out.println("Ukupan Broj Knjiga: " + ukupanBrojKnjiga);
		
		// 2
		biblioteka.listaSekcija.stream().flatMap(sekcija -> sekcija.listaPolica.stream())
			.flatMap(polica -> polica.listaKnjiga.stream()).map(knjiga -> knjiga.autor).collect(Collectors.toSet())
			.forEach(System.out::println);
			
		// 3
		biblioteka.listaSekcija.stream().map(sekcija -> sekcija.listaPolica.stream()
				.max(Comparator.comparingInt(polica -> polica.listaKnjiga.size()))
				.map(najvecaPolica -> Map.entry(sekcija, najvecaPolica)))
				.map(Optional::get).forEach(entry -> {
					System.out.println("Sekcija ID: " + entry.getKey().id);
					System.out.println("Najveca polica ID: " + entry.getValue().id);
					entry.getValue().listaKnjiga.forEach(knjiga -> {
					System.out.println(knjiga);
			});
		});
		
		// 4.
		biblioteka.listaSekcija.stream().forEach(sekcija -> {
			System.out.println("Sekcija ID: " + sekcija.id);
			
			sekcija.listaPolica.forEach(polica -> {
				System.out.println("  Polica ID: " + polica.id);
				
				polica.listaKnjiga.stream().sorted(Comparator.comparing(knjiga -> knjiga.naslov, Comparator.reverseOrder()))
				.forEach(knjiga -> {
					System.out.println(knjiga);
				});
			});
		});
	}
}
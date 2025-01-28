
import java.util.*;
import java.util.stream.*;
import java.util.function.*;

public class Main{
	
	public static ArrayList<Film> generateFilmovi(){
		Random random=new Random();
		ArrayList<Film> filmovi=new ArrayList<>();
		for(int i=1;i<=40;i++)
			filmovi.add(new Film("Film"+i,2022-(random.nextInt(40)),random.nextInt(50)*1000000,random.nextDouble()*9.0+1));
		return filmovi;
	}
	
	public static void main(String[] args){
		
		List<Film> listaFilmova = new ArrayList<>();
		listaFilmova = generateFilmovi();
		
		// provjera
		listaFilmova.stream().forEach(System.out::println);
		
		// kreirati listu filmova grupisanih po godini objavljivanja
		listaFilmova.stream().collect(Collectors.groupingBy(Film::getGodinaObjavljivanja)).forEach((godinaObjavljivanja, filmovi)->{
			System.out.println("Godina objavljivanja: " + godinaObjavljivanja);
			filmovi.forEach(System.out::println);
		});
		
		// kreirati listu filmova čija je ocjena veća ili jednaka zadatom broju,
		Scanner scanner = new Scanner(System.in);
		System.out.println("Unesite ocjenu za filtriranje: ");
		double ocjena = scanner.nextDouble();
		listaFilmova.stream().filter((film)->film.ocjena > ocjena).forEach(System.out::println);
		
		// kreirati listu filmova čiji je budžet veći od 10 miliona,
		System.out.println("Filmovi, ciji budzet prevazilazi 10 000 000 ..");
		listaFilmova.stream().filter((film)->film.budzet > 10_000_000).forEach(System.out::println); 
		
		// kreirati listu filmova koji su objavljeni u prvoj deceniji 2000-tih,
		System.out.println("Filmovi koji su objavljeni u prvoj deceniji 2000-tih..");
		listaFilmova.stream().filter((film)->film.godinaObjavljivanja >= 2000 && film.godinaObjavljivanja < 2010).forEach(System.out::println);
		
		// kreirati listu filmova grupisanih po ocjeni u formatu npr. 6,0-6,99, 7,0-7,99,...,9.0-10.0, 
		Function<Film,String> funkcija=(film)->{
			if(film.ocjena>=1&& film.ocjena <= 6.99)
				return "1.0-6.99";
			else if(film.ocjena>=7.0 && film.ocjena<=7.99)
				return "7.0-7.99";
			else if(film.ocjena>=8.0 && film.ocjena<=8.99)
				return "8.0-8.99";
			else //if(s.ocjena>=9.0 && s.ocjena<=10.0)
				return "9.0-10.0";	
		};
		
		listaFilmova.stream().collect(Collectors.groupingBy(funkcija)).entrySet().forEach((entrySetElement)->{
			System.out.println(entrySetElement.getKey());
			entrySetElement.getValue().forEach(System.out::println);
		});
		
		// izračunati prosječnu ocjenu filmova snimljenih 90-ih godina,
		System.out.println("Prosjecna ocjena filmova snimljenih 90-ih godina..");
		var rezultat = listaFilmova.stream().filter((film)->film.godinaObjavljivanja>=1990 && film.godinaObjavljivanja<2000)
		.mapToDouble(Film::getOcjena).average();
		System.out.println(rezultat.getAsDouble());
		
		// izačunati ukupni budžet filmova snimljenih 80-ih godina.
		System.out.println("Ukupni budzet filmova 80-ih..");
		var rezultat1 = listaFilmova.stream().filter((film)->film.godinaObjavljivanja>=1980 && film.godinaObjavljivanja<1990)
		.mapToDouble(Film::getBudzet).sum();
		System.out.println(rezultat1);
	}
}
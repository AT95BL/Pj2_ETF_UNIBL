
import java.util.stream.*;
import java.util.*;
import java.util.function.Predicate;
import java.util.function.Function;
// import java.util.function.*;

public class Main{
	
	public static void main(String[] args){
		
		Set<Pas> prvaGrupa = new HashSet<>();
		Set<Pas> drugaGrupa = new HashSet<>();
		
		// 1 
		for(int i=0; i < 20; i++){
			prvaGrupa.add(new Pas());
		}
		
		for(int i=20; i < 40; i++){
			drugaGrupa.add(new Pas());
		}
		
		prvaGrupa.addAll(drugaGrupa);
		drugaGrupa.clear();
		
		// 2
		Scanner scanner = new Scanner(System.in);
		System.out.println("Filtriranje, Unesite godinu: ");
		int nekaGodina = scanner.nextInt();
		
		Predicate<Pas> predikat = (pas) -> pas.godinaRodjenja == nekaGodina;
		prvaGrupa.stream()
		.filter(predikat)
		.collect(Collectors.groupingBy(pas -> pas.godinaRodjenja))
		.forEach((godinaRodjenja, psi)->{
			System.out.println(godinaRodjenja);
			psi.forEach(System.out::println);
		});
		
		// 3
		prvaGrupa
			.stream()
			.sorted(Comparator.comparingInt(pas->pas.omiljenaHrana.ordinal()))
			.forEach(System.out::println);
			
		// 4
		Function<Pas, Boolean> funkcija = (pas)->{
			if(pas.omiljenaHrana == OmiljenaHrana.PILETINA){
				return true;
			}
			return false;
		};
		
		double ukupnaTezina = prvaGrupa.stream()
                .filter(pas -> pas.godinaRodjenja % 2 == 0 && funkcija.apply(pas))
                .mapToDouble(pas -> pas.tezina) // Mapiranje na težinu
                .sum(); // Sumiranje težina

        System.out.println("Ukupna težina pasa: " + ukupnaTezina);
		
		// 5
		prvaGrupa
		.stream()
		.min(Comparator.comparingInt(Pas::getGodinaRodjenja))
		.ifPresent((pas) -> { System.out.println(pas.getGodinaRodjenja());});
		
		prvaGrupa
		.stream()
		.max(Comparator.comparingInt(Pas::getGodinaRodjenja))
		.ifPresent((pas) -> { System.out.println(pas.getGodinaRodjenja());});
	}
}
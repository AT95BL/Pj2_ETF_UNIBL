
import java.util.function.*;	//	Interface Predicate<T>
import java.util.*;
import java.util.stream.*;		//	streams.., Collectors

public class Main{
	
	public static void main(String[] args){
		
		// Deklaracija tri nezavisne liste studenata ..
		List<Student> listaStudenata1 = new ArrayList<>();
		List<Student> listaStudenata2 = new ArrayList<>();
		List<Student> listaStudenata3 = new ArrayList<>();
		
		// Dodavanje studenata u prvu listu ..
		listaStudenata1.add(new Student("Marko", "Markovic", "12345"));
		listaStudenata1.add(new Student("Ana", "Anic", "54321"));
		
		// Dodavanje studenata u drugu listu ..
		listaStudenata2.add(new Student("Ivan", "Ivanic", "67890"));
		listaStudenata2.add(new Student("Marija", "Marijic", "09876"));
		
		// Dodavanje studenata u trecu listu ..
		listaStudenata3.add(new Student("Petar", "Petrovic", "11111"));
		listaStudenata3.add(new Student("Jelena", "Jelenic", "22222"));
		
		// Deklaracija i Definicija 'Predicate' objekata!!
		Predicate<Student> imeStudentaPocinjeSlovom_M = student -> student.getIme().startsWith("M");
		Predicate<Student> prezimeStudentaPocinjeSlovom_I = student -> student.getPrezime().startsWith("I");
		Predicate<Student> indeksStudentaPocinjeBrojem_1 = student -> student.getIndeks().startsWith("1");
		
		// Dodavanje 'Predicate' objekata u listu ..
		ArrayList<Predicate<Student>> listaPredikata = new ArrayList<>();
		listaPredikata.add(imeStudentaPocinjeSlovom_M);
		listaPredikata.add(prezimeStudentaPocinjeSlovom_I);
		listaPredikata.add(indeksStudentaPocinjeBrojem_1);
		
		// Deklaracija i dodavanje elemenata u listu listi studenata..
		ArrayList<ArrayList<Student>> listaListiStudenata = new ArrayList<>();
		listaListiStudenata.add(new ArrayList<>(listaStudenata1));
		listaListiStudenata.add(new ArrayList<>(listaStudenata2));
		listaListiStudenata.add(new ArrayList<>(listaStudenata3));
		
		int pocetniElement = 0;
		int poslednjiElement = listaListiStudenata.size();
		// idemo definisati metodu 'metoda' ..
		
		// idemo pozvati genericku metodu 'metoda' ..
		List<Student> filtriraniStudenti = metoda(listaPredikata, pocetniElement, poslednjiElement, listaListiStudenata);
		
		if(!filtriraniStudenti.isEmpty()){
			
			System.out.println("Filtrirani Student: \n");
			
			for(var el:filtriraniStudenti){
				System.out.println(el);
			}
			
		}else{
			System.out.println("Lista je prazna ..");
		}
	}
	
	//	<T extends Podatak> --da naglasimo kako ova metoda radi sa 'tipom( Genericki Tip!!)) T', a 'T' je neka klasa koja 'extends Podatak'
	//	List<T>	je povratna vrijednost koju metoda 'metoda' vraca kao rezultat svog rada ..
	public static <T extends Podatak> List<T> metoda(ArrayList<Predicate<T>> listaPredikata,
															int pocetniElement,
															int poslednjiElement,
															List<ArrayList<T>> listaListiStudenata){
			
			ArrayList<T> rezultat = new ArrayList<>();
			
			for(var lista: listaListiStudenata){			//	prolazis kroz listu listi i u svakoj iteraciji select jednu listu ..
				for(var element: lista){					//	prolazis kroz selected listu i u svakoj iteraciji select jedan element iz te liste ..
					boolean status = true;
					for(var predikat: listaPredikata){		//	prolazis kroz listu predikata i u svakoj iteraciji select jedan element iz te liste ..
						if(predikat.test(element)){			//	sa selected-predicate ispitujes selected-element
							status = false;
							break;
						}
					}
					if(status){
						rezultat.add(element);
					}
				}
			}
			
			return rezultat.stream().sorted((a,b) -> Integer.compare(b.hashCode(), a.hashCode())).collect(Collectors.toList());
		}
}
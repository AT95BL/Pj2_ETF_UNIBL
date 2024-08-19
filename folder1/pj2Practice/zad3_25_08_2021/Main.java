
import java.util.List;
import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main{
	
	public static void main(String[] args){
		
		List<Student> listaStudenata1 = new ArrayList<>();
		listaStudenata1.add(new Student("Andrej", "Trozic", "666666"));	//	waaaaaa....
		listaStudenata1.add(new Student("Denis", "Jerkovic", "222222"));
		listaStudenata1.add(new Student("Boris", "Blagojevic", "333333"));
		
		List<Student> listaStudenata2 = new ArrayList<>();
		listaStudenata2.add(new Student("Armano", "Merdzic", "444444"));
		listaStudenata2.add(new Student("David", "Milanovic", "555555"));
		listaStudenata2.add(new Student("Mario", "Perac", "111111"));
		
		List<Student> listaStudenata3 = new ArrayList<>();
		listaStudenata3.add(new Student("Novak", "Cubic", "777777"));
		listaStudenata3.add(new Student("Marko", "Grujic", "888888"));
		listaStudenata3.add(new Student("Stefan", "Novakovic", "999999"));
		
		Predicate<Student> hasNameStartingWithA = student -> student.getIme().startsWith("A");
		Predicate<Student> hasSurnameStartingWithM = student -> student.getPrezime().startsWith("M");
		Predicate<Student> hasIndexLength6 = student -> student.getIndeks().length() == 6;
		
		try{
			ArrayList<ArrayList<Student>> listaListiStudenata = new ArrayList<>();
			listaListiStudenata.add(new ArrayList(listaStudenata1));
			listaListiStudenata.add(new ArrayList(listaStudenata2));
			listaListiStudenata.add(new ArrayList(listaStudenata3));
		
			ArrayList<Predicate<Student>> listaPredikata = new ArrayList<>();
			listaPredikata.add(hasNameStartingWithA);
			listaPredikata.add(hasSurnameStartingWithM);
			listaPredikata.add(hasIndexLength6);
			
			// Pozivanje generičke metode method
			List<Student> filteredStudents = method(listaPredikata, 0, 10, listaListiStudenata);
		
			// Ispis rezultata
			System.out.println("Filtrirani studenti:");
			if (filteredStudents.isEmpty()) {
				System.out.println("Nema rezultata.");
			} else {
					System.out.println("Broj filtriranih studenata: " + filteredStudents.size());
					for (Student student : filteredStudents) {
						System.out.println(student);
					}
				}	
	
		}catch(Exception ex){
			System.out.println("Mislio sam da ću upotrebom 'try-catch block' eliminisati poruke upozorenja..");
			ex.printStackTrace();
		}
	}
	
	public static <T extends Podatak> List<T> method(ArrayList<Predicate<T>> predicates,
														int start,
														int end,
														List<ArrayList<T>> lists){
		ArrayList<T> result = new ArrayList<>();
		
		for(var list: lists){				//	selektuješ sebi listu, a ideš listu po listu
			for(var el : list){				//	selektuješ sebi element iz liste, a ideš element po element
					boolean status = true;
				for(var pred:predicates){	//	selektuješ predikatsku funkciju, a ideš predikat po predikat
					if(!pred.test(el)){		//	OBRATI PAŽNJU NA POZIV .test() metode!!!	https://www.geeksforgeeks.org/java-8-predicate-with-examples/	
						status = false;
						break;
					}
				}
				if(status){
					result.add(el);			//	ako je element zadovoljio kriterijume, dodaj ga u rezultat-listu!
				}
			}
		}
		return result.stream()				//	u Java programskom jeziku, kriterijumsko-sortiranje elemenata se obavlja tako što se od KOLEKCIJE napravi STREAM!!
					.sorted((a, b) -> Integer.compare(b.hashCode(), a.hashCode())).collect(Collectors.toList());
	}
}

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main{
	
	public static void main(String[] args){
		// Kreiranje lista objekata klase Student
        List<Student> students1 = new ArrayList<>();
        students1.add(new Student("Marko", "Marković", "12345"));
        students1.add(new Student("Ana", "Anić", "54321"));

        List<Student> students2 = new ArrayList<>();
        students2.add(new Student("Ivan", "Ivanić", "67890"));
        students2.add(new Student("Marija", "Marić", "09876"));

        List<Student> students3 = new ArrayList<>();
        students3.add(new Student("Petar", "Petrović", "11111"));
        students3.add(new Student("Jelena", "Jelenić", "22222"));
		
		//$$#############################################################################################
		// Definisanje Predicate objekata za filtriranje
		Predicate<Student> hasNameStartingWithM = student -> student.getIme().startsWith("M");
		Predicate<Student> hasSurnameStartingWithI = student -> student.getPrezime().startsWith("I");
		Predicate<Student> hasIndexStartingWith1 = student -> student.getBrojIndeksa().startsWith("1");
		
		// Kreiranje liste lista podataka
		ArrayList<Predicate<Student>> predicates = new ArrayList<>();
		predicates.add(hasNameStartingWithM);
		predicates.add(hasSurnameStartingWithI);
		predicates.add(hasIndexStartingWith1);
		//$$#############################################################################################
		
		// Kreiranje liste lista podataka
        ArrayList<ArrayList<Student>> listOfLists = new ArrayList<>();
        listOfLists.add(new ArrayList<>(students1));
        listOfLists.add(new ArrayList<>(students2));
        listOfLists.add(new ArrayList<>(students3));
		
		// Pozivanje generičke metode method
        List<Student> filteredStudents = method(predicates, 0, 10, listOfLists);
		
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
	}
	
    // https://www.baeldung.com/java-generics
	public static <T extends Podatak> List<T> method(ArrayList<Predicate<T>> predicates, 
                                                        int start, 
                                                        int end, 
                                                        List<ArrayList<T>> lists) {
        ArrayList<T> result = new ArrayList<>();

        for (var list : lists) {
            for (var el : list) {
                boolean status = true;
                for (var pred : predicates) {
                    if (!pred.test(el)) {
                        status = false;
                        break;
                    }
                }
                if (status) {
                    result.add(el);
                }
            }
        }
        return result.stream().sorted((a, b) -> Integer.compare(b.hashCode(), a.hashCode())).collect(Collectors.toList());
    }		
}
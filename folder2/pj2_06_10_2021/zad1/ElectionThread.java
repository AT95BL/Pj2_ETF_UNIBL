import java.util.Random;
import java.util.ArrayList;
import java.util.HashSet;

public class ElectionThread extends Thread {
    private ArrayList<Student> studentiZaIzbor; 
    public HashSet<Student> rezultatiIzbora = new HashSet<>();                      // HashSet ensures unique students

    /*
     *  Konstruktor ove klase kao argument prihvata ArrayList<Student>
     *  nit radi svoj posao,    nakon terminacije niti,
     *  generisan je jedan HashSet<Student> za tu nit! 
     */
    public ElectionThread(ArrayList<Student> studentiZaIzbor) {
        this.studentiZaIzbor = studentiZaIzbor;
    }

    @Override
    public void run() {
        Random random = new Random();

        // pozicioniraj studenta
        for (var student : this.studentiZaIzbor) {
            System.out.println(student + " glasa na izborima");

            // realizacija glasanja
            while (true) {
                int kandidat = random.nextInt(this.studentiZaIzbor.size());         //  generisi slucajan broj 
                Student tmp = this.studentiZaIzbor.get(kandidat);                   //  lociraj kandidata sa tim brojem
                if (tmp.equals(student)) {                                          //  provjeri da možda slučajno ne glasa sam za sebe..
                    continue;                                                       // Student cannot vote for themselves
                }
                rezultatiIzbora.add(tmp);                                           // Record the vote
                break;
            }

            try {
                sleep((random.nextInt(3) + 3) * 1000); // Sleep for a random period between 3 and 5 seconds
            } catch (InterruptedException e) {
                System.out.println("Nit je prekinuta.");
            }
        }
    }
}

// This class represents a thread that simulates the voting process for a group of students.
// Each instance of ElectionThread represents the voting process for students from one faculty,
// allowing elections to take place concurrently for different faculties.
//
// During the execution of the thread:
// 1. Each student in the provided list votes.
// 2. The student selects a random candidate, ensuring they do not vote for themselves.
// 3. The results are stored in a HashSet, ensuring each student is counted only once.
// 4. The thread sleeps for a random period (between 3 and 5 seconds) after each vote.
//
// Note: The results of the election are publicly accessible via the 'rezultatiIzbora' HashSet.

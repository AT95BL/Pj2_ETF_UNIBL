
import java.util.*;
import java.nio.file.*;
import java.io.*;

public class Fakultet{
	String nazivFakulteta;
	ArrayList<Student> studentiFakulteta=new ArrayList<>();

	// Constructor
	public Fakultet(String nazivFakulteta){
		this.nazivFakulteta=nazivFakulteta;
	}

	public void upisiStudenta(Student student){
		this.studentiFakulteta.add(student);
	}

	public static void readStudents(Fakultet fakultet, Path path)throws StudentFileException{
		List<String> sveLinijeDatoteke=null;
		try{
			sveLinijeDatoteke=Files.readAllLines(path);	//	Pročitaj/Pohrani sve linije iz datoteke koja je na putanji 'path' ..
		}catch(IOException ex){
			System.err.println("Greska prilikom operacija citanja iz datoteke: " + path.toString());
			throw new StudentFileException();
		}

		for(var jednaLinijaDatoteke:sveLinijeDatoteke){							//	Pozicioniraš se na jednu liniju, prolaziš tako liniju po liniju..
			var sveRijeciJedneLinijeDatoteke=jednaLinijaDatoteke.split(" ");	// Razbiješ liniju na riječi, razmak koristiš kao separator između riječi..
			try{
				fakultet.upisiStudenta(new Student(sveRijeciJedneLinijeDatoteke[0], 
					sveRijeciJedneLinijeDatoteke[1], 
					sveRijeciJedneLinijeDatoteke[2])
				);											//	Upisuješ studenta na fakultet..
			}catch(IndexOutOfBoundsException ex){
				ex.printStackTrace();
				throw new StudentFileException();
			}
		}
	}
}
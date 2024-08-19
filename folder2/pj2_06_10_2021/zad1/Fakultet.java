
import java.util.ArrayList;
import java.util.List;
import java.nio.file.*;
import java.io.*;

public class Fakultet{
	public String imeFakulteta;
	public ArrayList<Student> studenti=new ArrayList<Student>();
	
	public Fakultet(String imeFakulteta){
		this.imeFakulteta=imeFakulteta;
	}
	
	public void upisiStudenta(Student s){
		this.studenti.add(s);
	}
	
	public static void readStudents(Fakultet f,Path path)throws StudentFileException{
		List<String> lines=null;
		try{
			lines=Files.readAllLines(path);
		}
		catch(IOException e){
			System.out.println("Greska prilikom io operacije!!");
			throw new StudentFileException();
		}
		for(var line:lines){
			var tmp=line.split(" ");
			try{
				f.upisiStudenta(new Student(tmp[0],tmp[1],tmp[2]));
			}
			catch(IndexOutOfBoundsException e){
				throw new StudentFileException();
			}
		}
	}	
}

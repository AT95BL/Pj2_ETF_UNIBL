
import java.util.Objects;

public class Student{
	 String ime;
	 String prezime;
	 String indeks;

	 // Constructor
	 public Student(){
	 	this.ime = this.prezime = this.indeks = "";
	 }

	 // Constructor
	 public Student(String ime, String prezime, String indeks){
	 	this.ime=ime;
	 	this.prezime=prezime;
	 	this.indeks=indeks;
	 }

	 @Override
	 public String toString(){
	 	return "Student: " + this.ime + " " + this.prezime + " " + this.indeks;
	 }

	 @Override
	 public boolean equals(Object obj){
	 	if(obj == null || (this.getClass() != obj.getClass())){
	 		return false;
	 	}else if(this == obj){
	 		return true;
	 	}

	 	Student s=(Student)obj;
	 	return Objects.equals(this.ime, s.ime) && 
	 		   Objects.equals(this.prezime, s.prezime) &&
	 		   Objects.equals(this.indeks, s.indeks);
	 }

	 @Override
	 public int hashCode(){
	 	return Objects.hash(this.ime, this.prezime, this.indeks);
	 }
}

import java.util.Objects;

public class Student implements Podatak{
	private static int GLOBAL_ID;
	int id;
	
	String ime;
	String prezime;
	String indeks;
	
	// Constructor
	public Student(){
		this.ime="";
		this.prezime="";
		this.indeks="";
		this.id = ++ GLOBAL_ID;
	}
	
	// Constructor
	public Student(String ime, String prezime, String indeks){
		this.ime = ime;
		this.prezime = prezime;
		this.indeks = indeks;
		this.id = ++GLOBAL_ID;
	}
	
	public String getIme(){
		return this.ime;
	}
	
	public void setIme(String ime){
		this.ime=ime;
	}
	
	public String getPrezime(){
		return this.prezime;
	}
	
	public void setPrezime(String prezime){
		this.prezime = prezime;
	}
	
	public String getIndeks(){
		return this.indeks;
	}
	
	public void setIndeks(String indeks){
		this.indeks = indeks;
	}
	
	@Override
	public String toString(){
		return
		"Student:" + this.id + "\n" +
		"Ime: " + this.ime + "\n" +
		"Prezime: " + this.prezime + "\n" +
		"Indeks: " + this.indeks;
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj == null || obj.getClass() != this.getClass()){ return false;}
		else if(obj == this){ return true; }
		
		Student std = (Student)obj;
		return this.ime.equalsIgnoreCase(std.ime) && this.prezime.equalsIgnoreCase(std.prezime) && this.indeks.equalsIgnoreCase(std.indeks);
	}
	
	@Override
	public int hashCode(){
		return Objects.hash(ime, prezime, indeks);
	}
}
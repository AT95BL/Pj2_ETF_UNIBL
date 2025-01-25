
public class Student implements Podatak{
	String ime;
	String prezime;
	String indeks;
	
	public static int STUDENT_ID=0;
	int id;
	
	// Constructor
	public Student(){
		this.id = ++STUDENT_ID;
	}
	
	// Constructor
	public Student(String ime, String prezime, String indeks){
		this.ime = ime;
		this.prezime = prezime;
		this.indeks = indeks;
		this.id = ++STUDENT_ID;
	}
	
	// get ..
	public String getIme(){return this.ime; } 
	public String getPrezime(){ return this.prezime; }
	public String getIndeks(){ return this.indeks; }
	
	// set ..
	public void setIme(String ime){  this.ime=ime; }
	public void setPrezime(String prezime){ this.prezime=prezime; }
	public void setIndeks(String indeks){ this.indeks=indeks; }
	
	@Override
	public String toString(){
		return "Student: " + this.ime + " " + this.prezime + "\n" +
		"Indeks: " + this.indeks;
	}
	
	@Override
	public void podatakInfo(){
		System.out.println("Student ID: " + this.id);
	}
}
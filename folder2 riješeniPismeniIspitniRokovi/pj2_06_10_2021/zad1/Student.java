
public class Student{
	public String ime;
	public String prezime;
	public String indeks;
	
	public Student(){
		this.ime=this.prezime=this.indeks="";
	}
	
	public Student(String ime,String prezime,String indeks){
		this.ime=ime;
		this.prezime=prezime;
		this.indeks=indeks;
	}
	
	@Override
	public String toString(){
		return "Student: " +this.ime+", "+this.prezime+", "+this.indeks;
	}
	
	@Override
	public boolean equals(Object other){
		if(!(other instanceof Student))
			return false;
		Student tmp=(Student)other;
		return this.indeks.equals(tmp.indeks);
	}
	
	@Override
	public int hashCode(){
		int hash=3;
		hash=7*hash+this.indeks.hashCode();
		return hash;
	}
}

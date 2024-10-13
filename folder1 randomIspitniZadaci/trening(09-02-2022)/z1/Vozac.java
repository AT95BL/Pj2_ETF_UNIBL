
public class Vozac{
	String ime;
	String prezime;
	
	// Constructor
	public Vozac(){
		this.ime="";
		this.prezime="";
	}
	
	// Constructor
	public Vozac(String ime, String prezime){
		this.ime=ime;
		this.prezime=prezime;
	}
	
	@Override
	public String toString(){
		return this.ime + " " + this.prezime;
	}
}
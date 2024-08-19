
public class Vozac{
	
	String ime;
	String prezime;
	// moja ideja..vozacima automatski generisem ime i prezime po šablonu 'string+i'
	public static int GLOBALNI_IDENTIFIKATOR;
	int identifikator;
	
	// Constructor
	public Vozac(String ime, String prezime){
		this.ime = ime;
		this.prezime = prezime;
		this.identifikator = ++GLOBALNI_IDENTIFIKATOR;
	}
	
	@Override
	public String toString(){
		return this.ime + " " + this.prezime;
	}
}
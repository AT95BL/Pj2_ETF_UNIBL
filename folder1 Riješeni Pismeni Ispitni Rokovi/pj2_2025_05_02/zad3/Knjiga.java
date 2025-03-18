
import java.util.Objects;

public class Knjiga{
	String naslov;
	String autor;
	int godinaIzdanja;
	Zanr zanr;
	int brojStranica;
	
	// Constructor
	public Knjiga(){
		
	}
	
	// Constructor
	public Knjiga(String naslov, String autor, int godinaIzdanja, Zanr zanr, int brojStranica){
		this.naslov = naslov;
		this.autor = autor;
		this.godinaIzdanja = godinaIzdanja;
		this.zanr = zanr;
		this.brojStranica = brojStranica;
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj.getClass() != this.getClass() || (obj == null)){
			return false;
		}
		
		Knjiga knjiga = (Knjiga)obj;
		return this.naslov == knjiga.naslov && this.autor == knjiga.autor;
	}

	/*
	 * 	Obavezno ili odoše bodovi..
	 */
	@Override
	public  int hashCode(){
		return Objects.hash(this.naslov, this.autor);
	}
	
	@Override
	public String toString(){
		return naslov + " " + autor + " " + godinaIzdanja + " " + zanr.toString() + " " + brojStranica;
	}
	
	public Zanr getZanr(){
		return this.zanr;
	}
	
	public int getGodinaIzdanja(){
		return this.godinaIzdanja;
	}
	
	public int getBrojStranica(){
		return this.brojStranica;
	}
}
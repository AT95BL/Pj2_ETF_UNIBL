
import java.util.Objects;

public class Knjiga{
	//	u sklopu zadatka, sve datoteke se nalaze u istom direktorijumu tako da nema smisla trositi vrijeme i energiju na dopisivanje public/private/protected kod atributa.. 
	String naslov;
	String pisac;
	int godinaIzdavanja;
	Zanr zanr;
	
	// Constructor	-brzine rade, redaj parametre po istom redoslijedu kako ti idu atributi,..
	public Knjiga(String naslov, String pisac, int godinaIzdavanja, Zanr zanr){
		this.naslov = naslov;
		this.pisac = pisac;
		this.godinaIzdavanja = godinaIzdavanja;
		this.zanr = zanr;
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj == this){return true; }
		
		else if(obj == null || obj.getClass() != this.getClass()){return false; }
		
		Knjiga knjiga = (Knjiga)obj;
		return this.godinaIzdavanja == knjiga.godinaIzdavanja && this.naslov.equals(knjiga.naslov);
	}
	
	@Override
	public int hashCode(){
		return Objects.hash(naslov, godinaIzdavanja);
	}
	
	@Override
	public String toString(){
		return 
			"Naslov: " + this.naslov + "\n" +
			"Pisac: " + this.pisac + "\n" +
			"Godina Izdavanja: " + this.godinaIzdavanja + "\n" +
			"Zanr: " + this.zanr.toString();			
	}
	
	//	kako mi sta zatreba za Stream API tako i definisem..
	public Zanr getZanr(){
		return this.zanr;
	}
	
	public int getGodinaIzdavanja(){
		return this.godinaIzdavanja;
	}
	
	public String getNaslov(){
		return this.naslov;
	}
}
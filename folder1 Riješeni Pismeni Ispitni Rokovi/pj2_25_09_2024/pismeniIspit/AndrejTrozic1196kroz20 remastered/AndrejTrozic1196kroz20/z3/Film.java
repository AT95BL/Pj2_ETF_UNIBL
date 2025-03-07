
import java.util.Objects;

public class Film{
	String nazivFilma;
	String reditelj;
	int godinaIzdavanja;
	Zanr zanr;
	
	// Constructor
	public Film(){}
	
	// Constructor
	public Film(String nazivFilma, String reditelj, int godinaIzdavanja, Zanr zanr){
		this.nazivFilma=nazivFilma;
		this.reditelj=reditelj;
		this.godinaIzdavanja=godinaIzdavanja;
		this.zanr=zanr;
	}
	
	@Override
	public String toString(){
		return this.nazivFilma + " " + this.reditelj + " " + this.godinaIzdavanja + " " + this.zanr.toString();
	}
	
	@Override
	public int hashCode(){
		return Objects.hash(this.godinaIzdavanja, this.nazivFilma);
	}
	
	@Override
	public boolean equals(Object obj){
		if(this == obj){return true;}
		else if(obj == null || (obj.getClass() != this.getClass())){return false;}
		
		Film f = (Film)obj;
		return Objects.equals(this.godinaIzdavanja, f.godinaIzdavanja) && Objects.equals(this.nazivFilma, f.nazivFilma);
	}
	
	public Zanr getZanr(){
		return this.zanr;
	}
	
	public int getGodinaIzdavanja(){
		return this.godinaIzdavanja;
	}
	
	public int getNazivFilmaLength(){
		return this.nazivFilma.length();
	}
}
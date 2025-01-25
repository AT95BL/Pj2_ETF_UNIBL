
import java.io.Serializable;
import java.util.Objects;

public abstract class Posiljka implements Serializable{
	private static int GLOBAL_ID;
	int id;
	
	String adresaPrimaoca;
	String adresaPosiljaoca;
	int tezina;
	
	// Constructor
	public Posiljka(){}
	
	// Constructor
	public Posiljka(String adresaPrimaoca, String adresaPosiljaoca, int tezina){
		this.adresaPrimaoca=adresaPrimaoca;
		this.adresaPosiljaoca=adresaPosiljaoca;
		this.tezina=tezina;
		
		this.id = ++GLOBAL_ID;
	}
	
	@Override
	public String toString(){
		return "Posiljka: " + this.id + "\n" 
		+ "Adresa primaoca: " + this.adresaPrimaoca + "\n"
		+ "Adresa posiljaoca: " + this.adresaPosiljaoca + "\n"
		+ "Tezina: " + this.tezina;
	}
	
	@Override
	public boolean equals(Object obj){
		if(this == obj){ 
			return true; 
		}
		else if(obj == null || (obj.getClass() != this.getClass())){
			return false;
		}
		
		Posiljka p = (Posiljka)obj;
		return Objects.equals(this.adresaPrimaoca, p.adresaPrimaoca) && 
			Objects.equals(this.adresaPrimaoca, p.adresaPrimaoca) &&
			Objects.equals(this.tezina, p.tezina);
	}
	
	@Override
	public int hashCode(){
		return Objects.hash(this.adresaPrimaoca, this.adresaPosiljaoca, this.tezina);
	}
}
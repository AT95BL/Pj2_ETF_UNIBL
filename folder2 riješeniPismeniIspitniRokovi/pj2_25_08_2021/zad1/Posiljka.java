import java.io.Serializable;

public abstract class Posiljka implements Serializable{
	
	private static int globalID;
	int id;
	
	String adresaPrimaoca;
	String adresaPosiljaoca;
	int tezina;					//	mozes generisati koristeci Random klasu ..
	
	// Konstruktor
	public Posiljka(){}
	
	// Konstruktor
	public Posiljka(String adresaPrimaoca, String adresaPosiljaoca, int tezina){
		
		this.id = ++globalID;
		this.adresaPrimaoca = adresaPrimaoca;
		this.adresaPosiljaoca = adresaPosiljaoca;
		this.tezina = tezina;
	}
		
	// Konstruktor
	public Posiljka(String adresaPrimaoca, String adresaPosiljaoca){
		
		this.id = ++globalID;
		this.adresaPrimaoca = adresaPrimaoca;
		this.adresaPosiljaoca = adresaPosiljaoca;
	}
	
	@Override
	public String toString(){
		
		return "Posiljka: " + this.id + "\n"
			+ "Adresa Primaoca: " + this.adresaPrimaoca + "\n"
			+ "Adresa Posiljaoca: " + this.adresaPosiljaoca + "\n"
			+ "Tezina: " + this.tezina;
	}
	
	@Override
	public boolean equals(Object object){
		
		if(object == null || !(object instanceof Posiljka ))
			return false;
		Posiljka posiljka = (Posiljka)object;
		return this.adresaPrimaoca.equals(posiljka.adresaPrimaoca) && this.adresaPosiljaoca.equals(posiljka.adresaPosiljaoca) && this.tezina == posiljka.tezina;
	}
	
	@Override
	public int hashCode(){
	
		int hash=3;
		hash=hash*7+this.adresaPosiljaoca.hashCode();
		hash=hash*7+this.adresaPrimaoca.hashCode();
		return hash;
	}
}
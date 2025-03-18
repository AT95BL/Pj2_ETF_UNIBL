
import java.io.*;

public class Posiljka implements Serializable{
	String adresaPrimaoca;
	String adresaPosiljaoca;
	int tezina;
	
	public static int POSILJKA_ID = 0;
	int posijkaID;
	
	// Constructor
	public Posiljka(){
		this.posijkaID = ++POSILJKA_ID;
	}
	
	// Constructor
	public Posiljka(String adresaPrimaoca, String adresaPosiljaoca){
		this.adresaPrimaoca = adresaPrimaoca;
		this.adresaPosiljaoca = adresaPosiljaoca;
		this.posijkaID = ++POSILJKA_ID;
	}
	
	@Override
	public String toString(){
		return "ID: " + this.posijkaID + "\n" +
		"Adresa Primaoca: " + this.adresaPrimaoca + "\n" +
		"Adresa Posiljaoca: " + this.adresaPosiljaoca + "\n" +
		"Tezina Posiljke: " + this.tezina + "\n";
	}
}

import java.util.ArrayList;

public class Drzava{
	String nazivDrzave;
	ArrayList<Univerzitet> univerziteti=new ArrayList<>();

	// Constructor
	public Drzava(String nazicDrzave){
		this.nazivDrzave=nazivDrzave;
	}

	// Kad god kao atribut klase imas 'vector', moras imati metodu za 
	// operaciju dodavanja elementa na vrh vektora!!
	public void dodajUniverzitet(Univerzitet univerzitet){
		this.univerziteti.add(univerzitet);
	}

	@Override
	public String toString(){
		return "Drzava: " + this.nazivDrzave;
	}
}
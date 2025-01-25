
import java.util.ArrayList;

public class Drzava{
	public String naziv;
	public ArrayList<Univerzitet> univerziteti=new ArrayList<>();
	
	public Drzava(String naziv){
		this.naziv=naziv;
	}
	
	public void dodajUniverzitet(Univerzitet u){
		this.univerziteti.add(u);
	}
}
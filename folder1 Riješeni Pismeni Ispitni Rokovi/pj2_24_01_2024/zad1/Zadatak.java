
import java.util.Random;

public class Zadatak{
	
	public static int ID = 0;
	int id;
	
	String tekstZadatka = "";
	
	Random random = new Random();
	
	//Constructor
	public Zadatak(){
		this.id = ++ID;
		this.tekstZadatka = "Zadatak" + this.id;
	}
	
	// Constructor
	public Zadatak(String tekstZadatka){
		this.id = ++ID;
		this.tekstZadatka = tekstZadatka;
	}
	
	@Override
	public String toString(){
		return this.tekstZadatka;
	}
}
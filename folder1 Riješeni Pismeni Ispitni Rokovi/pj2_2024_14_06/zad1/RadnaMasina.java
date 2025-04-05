
import java.util.Random;

public abstract class RadnaMasina extends Thread{
	public static int ID=0;
	int id=0;
	
	String serijskiBroj="";
	String model="";
	boolean status;
	String funkcija;
	
	Random random = new Random();
	
	// Constructor
	public RadnaMasina(String funkcija){
		this.id = ++ID;
		this.serijskiBroj = "SerijskiBroj" + this.id;
		this.model = "Model" + this.id;
		this.status = false;
		this.funkcija = funkcija;
	}
	
	@Override
	public String toString(){
		return "Serijski Broj: " + this.serijskiBroj + "\n" +
		"Model: " + this.model + "\n" +
		"Status: " + this.status + "\n" +
		"Funkcija: " + this.funkcija;
	}
	
	public double getGenerisanaTemperatura(){
		return random.nextDouble(100)+1;
	}
	
	public double getGenerisanNivoVlage(){
		return random.nextDouble(20)+1;
	}
	
	public double getGenerisanaJacinaPritiska(){
		return random.nextDouble(1000)+1;
	}
	
	public double getGenerisanStepenVibracije(){
		return random.nextDouble(10)+1;
	}
	
	@Override
	public void run(){
		
	}
}
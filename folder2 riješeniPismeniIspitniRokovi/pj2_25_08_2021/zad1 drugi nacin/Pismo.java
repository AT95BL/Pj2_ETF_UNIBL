
import java.util.Random;

public class Pismo extends Posiljka{
	
	String sadrzaj;
	
	Random random = new Random();
	
	// Constructor
	public Pismo(){
		super();
		this.tezina = random.nextInt(1,20);
	}
	
	// Constructor
	public Pismo(String adresaPrimaoca, String adresaPosiljaoca, String sadrzaj){
		super(adresaPrimaoca, adresaPosiljaoca);
		this.sadrzaj = sadrzaj;
		this.tezina = random.nextInt(1,20);
	}
	
	@Override
	public String toString(){
		return super.toString() + "Sadrzaj: " + this.sadrzaj + "\n";
	}
}
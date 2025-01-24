
import java.util.Random;
import java.io.*;

public class Razglednica extends Posiljka{
	
	String sadrzaj;
	String vizuelniDio;
	
	Random random = new Random();
	
	// Constructor
	public Razglednica(){
		super();
		this.tezina = random.nextInt(1, 10);
	}
	
	// Constructor
	public Razglednica(String adresaPrimaoca, String adresaPosiljaoca, String sadrzaj, String vizuelniDio)throws IllegalArgumentException{
		super(adresaPrimaoca, adresaPosiljaoca);
		this.sadrzaj = sadrzaj;
		
		// Provjera
		if(vizuelniDio.endsWith(".jpg") || vizuelniDio.endsWith(".jpeg") || vizuelniDio.endsWith(".png")){
			this.vizuelniDio = vizuelniDio;
		}else{
			throw new IllegalArgumentException("Dozvoljene ekstenzije: .jpg .jpeg .png");
		}
		
		this.tezina = random.nextInt(1, 10);
	}
	
	@Override
	public String toString(){
		return super.toString() + "Sadrzaj: " + this.sadrzaj + "\n" +
		"Vizuelni Dio: " + this.vizuelniDio + "\n";
	}
}

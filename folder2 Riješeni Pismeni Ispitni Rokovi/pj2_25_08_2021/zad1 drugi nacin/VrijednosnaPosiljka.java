
import java.util.Random;

public class VrijednosnaPosiljka extends Posiljka{
	
	Valuta valuta;
	
	Random random = new Random();
	
	// Constructor
	public VrijednosnaPosiljka(){
		super();
		this.tezina = random.nextInt(10, 100);
	}
	
	// Constructor
	public VrijednosnaPosiljka(String adresaPrimaoca, String adresaPosiljaoca, Valuta valuta){
		super(adresaPrimaoca, adresaPosiljaoca);
		this.valuta = valuta;
		this.tezina = random.nextInt(10, 100);
	}
	
	@Override
	public String toString(){
		return super.toString() + "Valuta: " + this.valuta.toString() + "\n";
	}
}
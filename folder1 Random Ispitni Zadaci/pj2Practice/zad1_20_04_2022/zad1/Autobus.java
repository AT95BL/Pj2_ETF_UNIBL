
import java.util.Random;

public class Autobus extends Vozilo{
	int MAKSIMALAN_BROJ_PUTNIKA = 52;
	Random random = new Random();
	
	// Constructor
	public Autobus(){
		super();
		//	automatski sve = 0 ili null ..
	}
	
	// Constructor
	public Autobus(
	
		Vozac vozac,
		Motor tipMotora){
			super(vozac, tipMotora);
			this.ukupanBrojPutnikaUVozilu = random.nextInt(8, MAKSIMALAN_BROJ_PUTNIKA)+1;
			this.cijenaVozila = random.nextDouble(3000, 5000);	//	Uzecemo nesto malo skromnije..
			this.maksimalanBrojPutnika = MAKSIMALAN_BROJ_PUTNIKA;
		}
}

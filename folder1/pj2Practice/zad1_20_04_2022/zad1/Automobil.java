
import java.util.Random;

public class Automobil extends Vozilo{
	int MAKSIMALAN_BROJ_PUTNIKA = 8;
	Random random = new Random();
	
	// Constructor
	public Automobil(){
		super();
		//	automatski sve = 0 ili null ..
	}
	
	// Constructor
	public Automobil(
		Vozac vozac,
		Motor tipMotora){
			super(vozac, tipMotora);
			this.ukupanBrojPutnikaUVozilu = random.nextInt(MAKSIMALAN_BROJ_PUTNIKA)+1;
			this.cijenaVozila = random.nextDouble(500, 1000);	//	Uzecemo nesto malo skromnije..
			this.maksimalanBrojPutnika = MAKSIMALAN_BROJ_PUTNIKA;
		}
}
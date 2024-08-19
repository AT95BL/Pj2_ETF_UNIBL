
import java.util.*;

public class Kamion extends Vozilo{
	int MAKSIMALAN_BROJ_PUTNIKA = 3;
	Random random = new Random();
	public List<Vozilo> listaAutomobila = new ArrayList<>();
	
	// Constructor
	public Kamion(){
		super();
		//	automatski sve = 0 ili null ..
	}
	
	// Constructor
	public Kamion(
		Vozac vozac,
		Motor tipMotora){
			
			super(vozac, tipMotora);
			
			this.ukupanBrojPutnikaUVozilu = random.nextInt(MAKSIMALAN_BROJ_PUTNIKA)+1;
			this.cijenaVozila = random.nextDouble(1500, 3000);	//	Uzecemo nesto malo skromnije..
			this.maksimalanBrojPutnika = MAKSIMALAN_BROJ_PUTNIKA;
			
			if(random.nextBoolean()){
				for(int i=100; i < 105; i++){
					this.listaAutomobila.add(new Automobil(new Vozac("ime"+i, "prezime"+i), new Motor()));
				}
			}
		}
}
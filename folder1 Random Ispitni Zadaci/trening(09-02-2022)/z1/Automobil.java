
public class Automobil extends SuperVozilo implements SuperMoci{
	public Automobil(){
		super();
	}
	
	public Automobil(int identifikator, Vozac vozac, Motor motor, String konfiguracija){
		super(identifikator, vozac, motor, konfiguracija);
	}
}
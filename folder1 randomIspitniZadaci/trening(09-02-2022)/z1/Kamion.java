

public class Kamion extends SuperVozilo implements PrevozTereta{
	public Kamion(){
		super();
	}
	
	public Kamion(int identifikator, Vozac vozac, Motor motor, String konfiguracija){
		super(identifikator, vozac, motor, konfiguracija);
	}
}
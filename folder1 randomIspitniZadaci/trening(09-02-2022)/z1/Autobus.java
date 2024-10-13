

public class Autobus extends SuperVozilo implements PrevozPutnika{
	public Autobus(){
		super();
	}
	
	public Autobus(int identifikator, Vozac vozac, Motor motor, String konfiguracija){
		super(identifikator, vozac, motor, konfiguracija);
	}
}
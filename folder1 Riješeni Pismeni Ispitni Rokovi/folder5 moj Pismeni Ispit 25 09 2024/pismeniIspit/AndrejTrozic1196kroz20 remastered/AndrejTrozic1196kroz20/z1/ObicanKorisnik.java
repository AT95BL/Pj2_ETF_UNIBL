
import java.util.Random;

public class ObicanKorisnik extends Korisnik{
	Random random = new Random();
	double nestoMaloKesa;
	boolean kupon;
	
	public ObicanKorisnik(){
		super();
		this.nestoMaloKesa=random.nextDouble(2, 12);
		
		double d = random.nextDouble(0.6);
		this.kupon = (d > 0.3) ? true:false;
	}
}
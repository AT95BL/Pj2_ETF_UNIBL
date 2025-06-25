
import java.util.*;

public class UkletiDvorac extends Atrakcijica{
	
	Random random = new Random();
	int MIN_POSJETILACA = 4;
	int MAX_POSJETILACA = 8;
	
	public UkletiDvorac(){
		super();
		this.naziv = " Ukletim Dvorcem..";
		
		this.brojPosjetilaca = random.nextInt(MIN_POSJETILACA, MAX_POSJETILACA);
		for(int i=MIN_POSJETILACA; i <brojPosjetilaca; i++){
			this.listaPosjetilaca.add(new Posjetilac());
		}
	}
	
	@Override
	public String toString(){
		return super.toString() + this.naziv;
	}
	
	public void run(){
		System.out.println(this);
		
		try{
			Thread.sleep(1000);
		}catch(InterruptedException ex){
			ex.printStackTrace();
		}
		
		// upis
		Main.printaj(this);
	}
}
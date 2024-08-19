
import java.util.Random;

public class Motor{
	String tipMotora;
	Random random = new Random();
	
	// Constructor
	public Motor(){
		int slucajanBroj = random.nextInt() % 4;
		
		switch(slucajanBroj){
			case 0: 
				this.tipMotora = "BENZIN"; 
				break;
			case 1: 
				this.tipMotora = "DIZEL"; 
				break;
			case 2: 
				this.tipMotora = "ELEKTRICNI"; 
				break;
			case 3: 
				this.tipMotora = "HIBRID"; 
				break;
		}
	}
	
	// Constructor
	public Motor(String tipMotora){
		this.tipMotora = tipMotora;
	}
	
	@Override
	public String toString(){
		return this.tipMotora;
	}
}
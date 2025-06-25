
import java.util.*;

public class RolerKoster extends Atrakcijica{
	
	Random random = new Random();
	int MIN_POSJETILACA = 10;
	int MAX_POSJETILACA = 30;
	
	public RolerKoster(){
		super();
		this.naziv = " RolerKosterom..";
		
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
		
		if((this.koordinataY == 0 && this.koordinataZ == 0) || (this.koordinataY == 10 && this.koordinataZ == 10)){
			System.out.println(this + " stigao do kraja mape..");
			Main.matrica[this.koordinataX][this.koordinataY][this.koordinataZ] = null;
			return;
		}
		
		if((this.koordinataY > 0 && this.koordinataY < 10) && (this.koordinataZ > 0 && this.koordinataZ < 10)){
			
			if(Main.matrica[this.koordinataX][this.koordinataY][this.koordinataZ-1] == null){
				System.out.println(this + " se krece ka gore ..");
				this.koordinataZ -= 1;
				Main.matrica[this.koordinataX][this.koordinataY][this.koordinataZ] = this;
				Main.matrica[this.koordinataX][this.koordinataY][this.koordinataZ+1] = null;
			
			}else if(Main.matrica[this.koordinataX][this.koordinataY][this.koordinataZ+1] == null){
				System.out.println(this + " se krece ka dole ..");
				this.koordinataZ += 1;
				Main.matrica[this.koordinataX][this.koordinataY][this.koordinataZ] = this;
				Main.matrica[this.koordinataX][this.koordinataY][this.koordinataZ-1] = null;
			}else{
				System.out.println("Sudar.. ukupno povrijedjenih: " + this.brojPosjetilaca + " ..nista strasno..");
				return;
			}
		}
		
		// upis
		Main.printaj(this);
	}
}
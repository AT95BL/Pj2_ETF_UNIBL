
import java.util.*;

public class TunelVoz extends Atrakcijica{
	
	Random random = new Random();
	int MIN_POSJETILACA = 8;
	int MAX_POSJETILACA = 20;
	
	public TunelVoz(){
		super();
		this.naziv = "TunelskimVozom..";
		
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
			
			if(Main.matrica[this.koordinataX][this.koordinataY-1][this.koordinataZ] == null){
				System.out.println(this + " se krece u lijevo ..");
				this.koordinataY -= 1;
				Main.matrica[this.koordinataX][this.koordinataY][this.koordinataZ] = this;
				Main.matrica[this.koordinataX][this.koordinataY+1][this.koordinataZ] = null;
			
			}else if(Main.matrica[this.koordinataX][this.koordinataY+1][this.koordinataZ] == null){
				System.out.println(this + " se krece u desno ..");
				this.koordinataY += 1;
				Main.matrica[this.koordinataX][this.koordinataY][this.koordinataZ] = this;
				Main.matrica[this.koordinataX][this.koordinataY-1][this.koordinataZ] = null;
			}else{
				System.out.println("Sudar.. ukupno povrijedjenih: " + this.brojPosjetilaca + " ..nista strasno..");
				return;
			}
		}
		
		// upis
		Main.printaj(this);
	}
}
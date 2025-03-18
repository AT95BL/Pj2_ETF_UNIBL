import java.util.ArrayList;
import java.util.Date;

public class SenderNit extends Thread{
	
	ArrayList<ArrayList<? extends Posiljka>> kolekcija = new ArrayList<>();
	ArrayList<Paket<? extends Posiljka>> paketi=new ArrayList<>();
	
	public SenderNit(ArrayList<ArrayList<? extends Posiljka>> kolekcija, ArrayList<Paket<? extends Posiljka>> paketi){
		this.kolekcija = kolekcija;
		this.paketi = paketi;
	}
	
	@Override
	public void run(){
		
		for(var paket:paketi){
			
			if(paket.ukupnaTezina > 15){
				
				for(int i=1; i<=3; i++){
					
					try{
						
						System.out.println("Šalje se " + i + ".dio");
						sleep(3000);
						
					}catch(InterruptedException ex){
						ex.printStackTrace();
					}
				}
				
				System.out.println("Paket uspješno poslat!! \n");
			}
		}
		
		for(var kol:kolekcija){
			
			for(var paket:kol){
				
				if(paket.tezina>15){
					
					for(int i=1; i<=3; i++){
					
					try{
						
						System.out.println("Šalje se " + i + ".dio");
						sleep(3000);
						
					}catch(InterruptedException ex){
						ex.printStackTrace();
					}
				}
				
				System.out.println("Paket uspješno poslat!! \n");
					
				}
			}
		}
		
		VirtuelnaPosta.endTime = new Date().getTime();
	}
}

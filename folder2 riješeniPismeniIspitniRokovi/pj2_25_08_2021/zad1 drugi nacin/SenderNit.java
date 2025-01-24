
import java.util.*;

public class SenderNit extends Thread{
	
	ArrayList<ArrayList<? extends Posiljka>> kolekcija = new ArrayList<>();
	ArrayList<Paket<? extends Posiljka>> paketi = new ArrayList<>();
	
	// Constructor
	public SenderNit(){
		
	}
		
	// Constructor
	public SenderNit(ArrayList<ArrayList<? extends Posiljka>> kolekcija, ArrayList<Paket<? extends Posiljka>> paketi){
		this.kolekcija = kolekcija;
		this.paketi = paketi;
	}
	
	@Override
	public void run(){
		
		for(var paket: paketi){
			
			if(paket.tezinaPaketa >= 15){
				
				for(int i=1; i<=3; i++){
					try{
						Thread.sleep(3000);
					}catch(Exception ex){
						ex.printStackTrace();
					}
					
					System.out.println("Salje se " + i + ". dio .. \n");
				}
			}	
			System.out.println("Paket uspjesno poslat..");
		}
		
		for(var listaPosiljki:kolekcija){
			
			for(var posiljka: listaPosiljki){
				
				if(posiljka.tezina >= 15){
					for(int i=1; i<=3; i++){
					try{
						Thread.sleep(3000);
					}catch(Exception ex){
						ex.printStackTrace();
					}
					
					System.out.println("Salje se " + i + ". dio .. \n");
					}
				}
			}
		}
		
		VirtuelnaPosta.END_TIME = new Date().getDate();
	}
}
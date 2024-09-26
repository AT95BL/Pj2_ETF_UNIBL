
import java.util.ArrayList;
import java.util.Date;

public class SenderNit extends Thread{
	ArrayList<ArrayList<? extends Posiljka>> kolekcijaPosiljki = new ArrayList<>();
	ArrayList<Paket<? extends Posiljka>> paketi = new ArrayList<>();
	
	// Constructor
	public SenderNit(ArrayList<ArrayList<? extends Posiljka>> kolekcijaPosiljki, ArrayList<Paket<? extends Posiljka>> paketi){
		this.kolekcijaPosiljki = kolekcijaPosiljki;
		this.paketi = paketi;
	}
	
	@Override
	public void run(){
		
		for(var paket:paketi){
			if(paket.ukupnaTezinaPaketa >= 15){
				for(int i=1; i<=3; i++){
					System.out.println("Salje se " + i + ". dio paketa..");
					try{
						Thread.sleep(3000);
					}catch(InterruptedException ex){
						ex.printStackTrace();
					}
				}
			}
			System.out.println("Paket uspjesno poslat!!");
		}
		
		for(var kolekcijaIzKolekcijePosiljki:kolekcijaPosiljki){
			for(var kolekcija:kolekcijaIzKolekcijePosiljki){
					if(kolekcija.tezina >= 15){
					for(int i=1; i<=3; i++){
						System.out.println("Salje se " + i + ". dio kolekcije..");
						try{
							Thread.sleep(3000);
						}catch(InterruptedException ex){
							ex.printStackTrace();
						}
					}
				}
				System.out.println("Kolekcija uspjesno poslata!!");
			}
		}
		
		VirtuelnaPosta.endTime = new Date().getTime();
	}
}
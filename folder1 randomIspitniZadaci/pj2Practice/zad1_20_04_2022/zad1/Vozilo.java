
import java.util.Random;

public abstract class Vozilo extends Thread{
	Vozac vozac;
	int ukupanBrojPutnikaUVozilu;
	double cijenaVozila;
	public static int GLOBALNI_IDENTIFIKATOR;
	int identifikator;
	Motor tipMotora;
	int koordinataX;
	int koordinataY;
	int maksimalanBrojPutnika; // moja ideja, flag preko kojeg cu prepoznati na koji terminal da posaljem vozilo..
	
	private static final Object lockBlock = new Object();
	Random random = new Random();
	
	// Constructor
	public Vozilo(){
		//	automatski sve = 0 ili null ..
	}
	
	// Constructor
	public Vozilo(
		Vozac vozac,
		Motor tipMotora){
			
			this.vozac = vozac;
			this.tipMotora = tipMotora;
			this.identifikator = ++GLOBALNI_IDENTIFIKATOR;
			
			this.postaviVoziloNaMapu();
		}
		
	public void postaviVoziloNaMapu(){
		synchronized(lockBlock){	//	ovo se ne radi tokom trajanja simulacije, ima li smisla da sav code-snippet bude unutar synchrionized??
			
			int slucajnaKoordinataX = random.nextInt(Simulacija.BROJ_VRSTA);
			int slucajnaKoordinataY = random.nextInt(Simulacija.BROJ_KOLONA-5);
			
			while(Simulacija.mapa[slucajnaKoordinataX][slucajnaKoordinataY] != null){
				slucajnaKoordinataX = random.nextInt(Simulacija.BROJ_VRSTA);
				slucajnaKoordinataY = random.nextInt(Simulacija.BROJ_KOLONA-5);
			}
			
			this.koordinataX = slucajnaKoordinataX;
			this.koordinataY = slucajnaKoordinataY;
			Simulacija.mapa[this.koordinataX][this.koordinataY] = this;
		}
	}
	
	public void kretanje(){
		synchronized(lockBlock){
			
			if(Simulacija.mapa[this.koordinataX][this.koordinataY+1] == null){
				this.koordinataY++;
				Simulacija.mapa[this.koordinataX][this.koordinataY] = this;
				Simulacija.mapa[this.koordinataX][this.koordinataY-1] = null;
				System.out.println(this);
			}
		}
	}
	
	@Override
	public String toString(){
		return "Vozilo: " + this.identifikator + "\n" +
			"Vozac: " + this.vozac + "\n" +
			"Ukupan Broj Putnika U Vozilu: " + this.ukupanBrojPutnikaUVozilu + "\n" +
			"Tip Motora: " + this.tipMotora + "\n" +
			"(X,Y): " + "(" + this.koordinataX + "," + this.koordinataY + ")" + "\n";
	}
	
	@Override
	public void run(){
		
		while(this.koordinataY < 11){
			kretanje();
			
			try{
				Thread.sleep(1000);
			}catch(InterruptedException ex){
				ex.printStackTrace();
			}
		}
		
		if(this.maksimalanBrojPutnika == 8){
			synchronized(lockBlock){
				int x = this.koordinataX;
				int y = this.koordinataY;
				int duzinaOstatkaMape = 2;
				this.koordinataX = 0;
				this.koordinataY = 12;
				Simulacija.mapa[this.koordinataX][this.koordinataY] = this;
				Simulacija.mapa[x][y]=null;
				while(duzinaOstatkaMape-- != 0){
					this.kretanje();
				}
				Simulacija.listaTerminala.getFirst().procesuirajAutomobil(this);
			}
		}
		else if(this.maksimalanBrojPutnika == 3){
			synchronized(lockBlock){
				int x = this.koordinataX;
				int y = this.koordinataY;
				this.koordinataX = 1;
				this.koordinataY = 12;
				int duzinaOstatkaMape = 2;
				Simulacija.mapa[this.koordinataX][this.koordinataY] = this;
				Simulacija.mapa[x][y]=null;
				while(duzinaOstatkaMape-- != 0){
					this.kretanje();
				}
				Simulacija.listaTerminala.get(1).procesuirajKamion(this);
			}
		}
		else{
			synchronized(lockBlock){
				int x = this.koordinataX;
				int y = this.koordinataY;
				this.koordinataX = 2;
				this.koordinataY = 12;
				int duzinaOstatkaMape = 2;
				Simulacija.mapa[this.koordinataX][this.koordinataY] = this;
				Simulacija.mapa[x][y]=null;
				while(duzinaOstatkaMape-- != 0){
					this.kretanje();
				}
				Simulacija.listaTerminala.getLast().procesuirajKamion(this);
			}
		}
	}
}

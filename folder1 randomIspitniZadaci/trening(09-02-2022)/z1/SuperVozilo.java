
import java.util.Date;
import java.util.Random;

public abstract class SuperVozilo extends Thread{
	int identifikator;
	Vozac vozac;
	Motor motor;
	String konfiguracija;
	double brzina;
	
	int koordinataX;
	
	long startTime;
	long endTime;
	boolean zavrsio;
	
	// Default Constructor
	public SuperVozilo(){
		identifikator=0;
		vozac=null;
		motor=null;
		konfiguracija="";
		brzina=0.0;
		
		koordinataX=0;
		konfiguracija="";
		zavrsio=false;
	}
	
	// Constructor
	public SuperVozilo(int identifikator, Vozac vozac, Motor motor, String konfiguracija){
		this.identifikator=identifikator;
		this.vozac=vozac;
		this.motor=motor;
		this.konfiguracija=konfiguracija;
		
		try{
			this.brzina=100.0/Integer.parseInt(konfiguracija);
		}catch(ArithmeticException ex){
			System.err.println(ex);
			this.brzina=101;	//	da program ne pada ..
		}
	}
	
	public long getVrijemeKretanja(){
		return this.endTime - this.startTime;
	}
	
	@Override
	public String toString(){
		return "Vozilo: " + this.identifikator + "\n" +
			"Vozac" + this.vozac + "\n" +
			"Konfiguracija: " + this.konfiguracija + "\n" +
			"Brzina: " + this.brzina + "\n" +
			"KoordinataX: " + this.koordinataX + "\n" +
			"(StartTime, EndTime)=" + "(" + this.startTime + ", " + this.endTime + ")";
	}
	
	@Override
	public void run(){
		Random random=new Random();
		this.startTime=new Date().getTime();
		
		for(this.koordinataX=0; this.koordinataX<Simulacija.mapa.length; this.koordinataX++){
			
			System.out.println(this);
			double brzinaKopija=this.brzina;
			
			if("NERAVNO".equalsIgnoreCase(Simulacija.mapa[this.koordinataX])){
				brzinaKopija=this.brzina+(this.brzina/10.0);
				System.out.println(this+" se nalazi na neravnom polju i smanjio je brzinu");
				
			}else if("KLIZAVO".equalsIgnoreCase(Simulacija.mapa[this.koordinataX])){
				int num=random.nextInt(100);
				if(num<Simulacija.SANSA_ZA_PREVRTANJE)
				{
					System.out.println(this+" se prevrnulo");
					this.zavrsio=false;
					break;
				}
			}
			
			try
			{
				//long tmp=(long)(brz*1000.0);
				sleep((long)(brzinaKopija*1000.0));
			}
			catch(InterruptedException e)
			{
				System.out.println("PREKID!!");
			}
		}
		this.zavrsio=true;
		this.endTime=new Date().getTime();
		return;
	}
} 
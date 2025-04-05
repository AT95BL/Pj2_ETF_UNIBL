
import java.io.*;
import java.nio.*;

public class MasinaZaSjecenje extends RadnaMasina{
	public static String message = "FLEKSERICA";
	
	SenzorTemperatura senzorTemperatura = null;
	// SenzorPritisak senzorPritisak = null;
	SenzorVlaga senzorVlaga = null;
	SenzorVibracija senzorVibracija = null;
	
	public MasinaZaSjecenje(){
		super(message);
		
		this.senzorTemperatura = new SenzorTemperatura();
		this.senzorVlaga = new SenzorVlaga();
		this.senzorVibracija = new SenzorVibracija();
	}
	
	@Override
	public void run(){
		
		this.status = true;
		
		try{
			Thread.sleep(1000);
		}catch(InterruptedException ex){
			System.err.println(ex);
		}
		
		System.out.println("Paljenje..\n" + this);
		
		while(this.status){
			
			// this.senzorPritisak.listaPritisaka.add(this.getGenerisanaJacinaPritiska());
			this.senzorTemperatura.listaTemperatura.add(this.getGenerisanaTemperatura());
			this.senzorVlaga.kolekcijaVlage.add(this.getGenerisanNivoVlage());
			this.senzorVibracija.listaVibracija.add(this.getGenerisanStepenVibracije());
			
			System.out.println(this);
			try{
			Thread.sleep(1000);
			}catch(InterruptedException ex){
				System.err.println(ex);
			}
			
			if(!JavaFabrika.STATUS){
				this.status = false;
			}
		}
	}
	
	public void printIzvjestaj(){
		
		File izlaznaDatoteka = new File("Flekserica.txt");
		
		try{
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(izlaznaDatoteka)));
			
			if(senzorTemperatura.listaTemperatura.size() > 0){
				for(var temperatura:senzorTemperatura.listaTemperatura){
					pw.println(temperatura);
				}
			}
			
			if(senzorVlaga.kolekcijaVlage.size() > 0){
				for(var vlaga:senzorVlaga.kolekcijaVlage){
					pw.println(vlaga);
				}
			}
			
			if(senzorVibracija.listaVibracija.size() > 0){
				for(var vibracija:senzorVibracija.listaVibracija){
					pw.println(vibracija);
				}
			}
			
		}catch(IOException ex){
			System.err.println(ex);
		}
	}
}
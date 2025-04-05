
import java.io.*;
import java.nio.*;

public class MasinaZaVarenje extends RadnaMasina{
	public static String message = "LEMILICA";
	
	SenzorPritisak senzorPritisak = null;
	SenzorTemperatura senzorTemperatura = null;
	
	public MasinaZaVarenje(){
		super(message);
		
		senzorPritisak = new SenzorPritisak();
		senzorTemperatura = new SenzorTemperatura();
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
			
			this.senzorPritisak.listaPritisaka.add(this.getGenerisanaJacinaPritiska());
			this.senzorTemperatura.listaTemperatura.add(this.getGenerisanaTemperatura());
			
			System.out.println(this);
			try{
			Thread.sleep(1000);
			}catch(InterruptedException ex){
				System.err.println(ex);
			}
			
			if(!JavaFabrika.STATUS){
				this.status = false;
				printIzvjestaj();
			}
		}
	}
	
	public void printIzvjestaj(){
		
		File izlaznaDatoteka = new File("Flekserica.txt");
		
		try{
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(izlaznaDatoteka)));
			
			if(senzorPritisak.listaPritisaka.size() > 0){
				for(var pritisak:senzorPritisak.listaPritisaka){
					pw.println(pritisak);
				}
			}
			
			if(senzorTemperatura.listaTemperatura.size() > 0){
				for(var temperatura:senzorTemperatura.listaTemperatura){
					pw.println(temperatura);
				}
			}
			
		}catch(IOException ex){
			System.err.println(ex);
		}
	}
}
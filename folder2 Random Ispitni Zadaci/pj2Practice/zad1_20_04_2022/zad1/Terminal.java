
import java.util.*;
import java.io.*;

public class Terminal{
	public static int GLOBALNI_IDENTIFIKATOR;
	int identifikator;
	static int taksaAutomobili=0;
	static int taksaKamioni=0;
	static int taksaAutobusi=0;
	
	public Terminal(){
		this.identifikator = ++GLOBALNI_IDENTIFIKATOR;
	}
	
	public void procesuirajAutomobil(Vozilo a){
		
		System.out.println("Procesuiranje Automobila: \n" + a);
		
		if("HIBRIDNI".equalsIgnoreCase(a.tipMotora.tipMotora)){
			taksaAutomobili += 50;
		}else{
			taksaAutomobili += 100;
		}
		
		try{
			Thread.sleep(1000);
		}catch(InterruptedException ex){
			ex.printStackTrace();
		}
	}
	
	public void procesuirajKamion(Vozilo v){
		
		Kamion k = (Kamion)v;
		
		System.out.println("Procesuiranje Kamiona: \n" + k);
		
		if(!k.listaAutomobila.isEmpty()){
			taksaAutomobili += (k.listaAutomobila.size()*100);
		}
		
		taksaKamioni += 200;
		
		try{
			Thread.sleep(2000);
		}catch(InterruptedException ex){
			ex.printStackTrace();
		}
	}
	
	public void procesuirajAutobus(Vozilo a){
		
		System.out.println("Procesuiranje Autobusa: \n" + a);
		
		taksaAutobusi += (a.ukupanBrojPutnikaUVozilu*20);
		
		try{
			Thread.sleep(2000);
		}catch(InterruptedException ex){
			ex.printStackTrace();
		}
	}
	
	public static void podnesiIzvjestaj(){
		
		try(PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("Izvjestaj.txt")))){
			writer.write("Ukupna taksa za automobile: " + taksaAutomobili + "\n");
			writer.write("Ukupna taksa za kamione: " + taksaKamioni + "\n");
			writer.write("Ukupna taksa za autobuse: "+ taksaAutobusi + "\n");
			
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
	
	@Override
	public String toString(){
		return "TERMINAL" + this.identifikator;
	}
}
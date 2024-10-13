
import java.util.Scanner;
import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Collections;

public class Simulacija{
	public static String[] mapa=new String[1];
	public static int SANSA_ZA_PREVRTANJE=25;
	
	static final String VOZILA_PATH="datoteke/Vozila.txt";
	static final String MAPA_PATH="datoteke/Mapa.txt";
	
	ArrayList<SuperVozilo> listaVozila;
	
	public Simulacija()throws IOException{
		VoziloParser vp=new VoziloParser(Paths.get(VOZILA_PATH));
		MapParser mp=new MapParser(Paths.get(MAPA_PATH));
		this.listaVozila=vp.importFromFile();
		mapa=mp.importFromFile().toArray(mapa);
	}
	
	public static void main(String[] args){
		Simulacija simulacija=null;
		try{
			simulacija=new Simulacija();
		}catch(IOException ex){
			System.out.println("Greska prilikom ocitavanja fajlova za simulaciju!!");
			return;
		}
		
		for(var el:simulacija.listaVozila){
			el.start();
		}
		for(var el:simulacija.listaVozila){
			try{
				el.join();
			}catch(InterruptedException ex){
				System.err.println(ex);
			}
		}
		
		Collections.sort(simulacija.listaVozila,(a,b)->(int)a.getVrijemeKretanja()-(int)b.getVrijemeKretanja());
		System.out.println("Vrijeme kretanja vozila:");
		simulacija.listaVozila.forEach((v)->{System.out.println("Vozilo"+v.identifikator+" je zavrsilo kretanja za vrijeme "+v.getVrijemeKretanja());});
		System.out.println("Rang lista:");
		int br=1;
		for(int i=0;i<simulacija.listaVozila.size();i++)
			if(simulacija.listaVozila.get(i).zavrsio)
				System.out.println("Vozilo "+simulacija.listaVozila.get(i).identifikator+" je zavrsila trku za vrijeme:"
			+simulacija.listaVozila.get(i).getVrijemeKretanja()+" na poziciji "+(br++));
		var rez=simulacija.listaVozila.stream().mapToLong(SuperVozilo::getVrijemeKretanja).average();
		System.out.println("Prosjecno vrijeme kretanja:"+rez.getAsDouble());
	}
}

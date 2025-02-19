
import java.util.*;
import java.io.*;
import java.nio.file.*;

public class Transakcija extends Thread {
	public String vrsta;
	public String korisnikUnos;
	public int iznos;
	public String korisnikIznos;
	
	long startTime = 0;
	long endTime = 0;
	
	Scanner scanner = new Scanner(System.in);
	String stringPutanja = "";
	Path putanja = null;
	
	// Constructor
	public Transakcija(){
		
	}
	
	// Constructor
	public Transakcija(String vrsta, String korisnikUnos, int iznos, String korisnikIznos){
		
		try{
			if(!"u".equals(vrsta) || !"i".equals(vrsta) || !"p".equals(vrsta)){
				throw new Izuzetak("u i p");
			}
			this.vrsta = vrsta;
		
			this.korisnikUnos = korisnikUnos;
		
			if(iznos <= 0){
				throw new Izuzetak("<=0!!!??");
			}
			this.iznos = iznos;
			
			this.korisnikIznos = korisnikIznos;
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public ArrayList<Transakcija> generisiTransakcije(){
		
		ArrayList<Transakcija> listaTransakcija = new ArrayList<>();
		int i=0;
		
		try{
			
			System.out.println("Putanja: ");
			stringPutanja = scanner.nextLine();
			putanja = Paths.get(stringPutanja);
			// Path putanja = Paths.get("C:\\Users\\Student\\Desktop\\AndrejTrozic 1196kroz20\\zad1\\transakcije.txt");
			List<String> linijeDatoteke = Files.readAllLines(putanja);
			
			for(String linijaDatoteke:linijeDatoteke){
				if(i == 0){ continue; }
				
				String[] rijeciDatoteke = linijaDatoteke.split(";");
				Transakcija transakcija = new Transakcija(rijeciDatoteke[0], rijeciDatoteke[1], new Integer(rijeciDatoteke[2]), rijeciDatoteke[3]);
				listaTransakcija.add(transakcija);
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		return listaTransakcija;
	}
	
	@Override
	public void run(){
		this.startTime = new Date().getTime();
		
		try{
			Thread.sleep(3000);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		System.out.println(this);
	}
	
	@Override
	public String toString(){
		return vrsta + " " + korisnikUnos + " " + iznos + " " + korisnikIznos;
	}
}
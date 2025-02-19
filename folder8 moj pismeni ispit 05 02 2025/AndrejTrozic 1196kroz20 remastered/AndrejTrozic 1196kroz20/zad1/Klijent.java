
import java.util.*;
import java.io.*;
import java.nio.file.*;

public class Klijent{
	public String imeVlasnika;
	public String brojRacuna;
	public int stanjeNaRacunu;
	
	Scanner scanner = new Scanner(System.in);
	String stringPutanja = "";
	Path putanja = null;
	
	// Constructor
	public Klijent(){
		
	}
	
	// Constructor
	public Klijent(String imeVlasnika, String brojRacuna, int stanjeNaRacunu){
		this.imeVlasnika = imeVlasnika;
		this.brojRacuna = brojRacuna;
		this.stanjeNaRacunu = stanjeNaRacunu;
	}
	
	public ArrayList<Klijent> generisiKlijente(){
		
		ArrayList<Klijent> listaKlijenata = new ArrayList<>();
		int i=0;
		
		try{
			
			System.out.println("Putanja: ");
			stringPutanja = scanner.nextLine();
			putanja = Paths.get(stringPutanja);
			
			// Path putanja = Paths.get("C:\\Users\\Student\\Desktop\\AndrejTrozic 1196kroz20\\zad1\\racuni.txt");
			List<String> linijeDatoteke = Files.readAllLines(putanja);
			
			for(String linijaDatoteke:linijeDatoteke){
				if(i == 0){ continue; }
				
				String[] rijeciDatoteke = linijaDatoteke.split(";");
				Klijent klijent = new Klijent(rijeciDatoteke[0], rijeciDatoteke[1], new Integer(rijeciDatoteke[2]));
				listaKlijenata.add(klijent);
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		return listaKlijenata;
	}
	
	@Override
	public String toString(){
		return imeVlasnika + " " + brojRacuna + " " + stanjeNaRacunu;
	}
	
}
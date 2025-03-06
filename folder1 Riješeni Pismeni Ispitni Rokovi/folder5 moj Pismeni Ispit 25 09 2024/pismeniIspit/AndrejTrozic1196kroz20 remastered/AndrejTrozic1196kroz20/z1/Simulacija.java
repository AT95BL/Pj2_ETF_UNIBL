
import java.util.*;

public class Simulacija{
	
	public static final Object BAZEN = new Object();
	public static final Object SAUNA = new Object();
	public static final Object MASAZA = new Object();
	
	public static ArrayList<ObicanKorisnik> generisiListuObicnihKorisnika(){
		ArrayList<ObicanKorisnik> lista = new ArrayList<>();
		for(int i=0; i<15; i++){
			lista.add( new ObicanKorisnik());
		}
		return lista;
	}
	
	public static ArrayList<ObicanKorisnik> generisiListuFirmaKorisnika(){
		ArrayList<ObicanKorisnik> lista = new ArrayList<>();
		for(int i=0; i<15; i++){
			lista.add( new ObicanKorisnik());
		}
		return lista;
	}
	
	public static void generisiSlucajanRaspored(ArrayList<ObicanKorisnik> listaObicnihKorisnika, ArrayList<ObicanKorisnik> listaFirmaKorisnika){
		for(var obicanKorisnik:listaFirmaKorisnika){
			Random random = new Random();
			int x = random.nextInt();
			if(x % 3 == 0){
				obicanKorisnik.bazen = true;
				obicanKorisnik.sauna = false;
				obicanKorisnik.masaza = false;
				obicanKorisnik.nestoMaloKesa -= 5;
			} else if(x % 3 == 1){
				obicanKorisnik.bazen = false;
				obicanKorisnik.sauna = true;
				obicanKorisnik.masaza = false;
			}else{
				obicanKorisnik.bazen = false;
				obicanKorisnik.sauna = false;
				obicanKorisnik.masaza = true;
				obicanKorisnik.nestoMaloKesa -= 10;
			}
		}
		
		for(var firmaKorisnik:listaFirmaKorisnika){
			Random random = new Random();
			int x = random.nextInt();
			if(x % 3 == 0){
				firmaKorisnik.bazen = true;
				firmaKorisnik.sauna = false;
				firmaKorisnik.masaza = false;
			} else if(x % 3 == 1){
				firmaKorisnik.bazen = false;
				firmaKorisnik.sauna = true;
				firmaKorisnik.masaza = false;
			}else{
				firmaKorisnik.bazen = false;
				firmaKorisnik.sauna = false;
				firmaKorisnik.masaza = true;
			}
		}
	}
	
	public static void main(String[] args){
		ArrayList<ObicanKorisnik> listaObicnihKorisnika = generisiListuObicnihKorisnika();
		ArrayList<ObicanKorisnik> listaFirmaKorisnika = generisiListuFirmaKorisnika();
		generisiSlucajanRaspored(listaObicnihKorisnika, listaFirmaKorisnika);
		
		for(var korisnik:listaObicnihKorisnika){
			korisnik.start();
			try{
				korisnik.join();
			}catch(InterruptedException ex){
				ex.printStackTrace();
			}
		}
		
		for(var korisnik:listaFirmaKorisnika){
			korisnik.start();
			try{
				korisnik.join();
			}catch(InterruptedException ex){
				ex.printStackTrace();
			}
		}
		
		for(var korisnik:listaObicnihKorisnika){
			System.out.println(korisnik + " Nesto malo kesa sto mu je ostalo: " + korisnik.nestoMaloKesa);
		}
	}
}
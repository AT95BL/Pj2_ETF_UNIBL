
import java.util.*;
import java.util.stream.*;

public class Simulacija{
	public static final int BROJ_VRSTA=3;
	public static final int BROJ_KOLONA=15;
	
	public static Object[][] mapa;
	public static List<Vozilo> listaVozila = new ArrayList<>();
	public static List<Terminal> listaTerminala = new ArrayList<>();
	
	public Simulacija(){
		this.mapa = new Object[BROJ_VRSTA][BROJ_KOLONA];
		this.listaVozila = generisiListuVozila();
		this.listaTerminala = generisiListuTerminala();
		
		// bespotrebno i bezveze al ajd..
		Simulacija.mapa[0][BROJ_KOLONA-1] = listaTerminala.getFirst();
		Simulacija.mapa[1][BROJ_KOLONA-1] = listaTerminala.get(1);
		Simulacija.mapa[2][BROJ_KOLONA-1] = listaTerminala.getLast();
	}
	
	public ArrayList<Vozilo> generisiListuVozila(){
		
		ArrayList<Vozilo> listaVozila = new ArrayList<>();
		
		for(int i=0; i < 5; i++)
			listaVozila.add(new Automobil(new Vozac("ime"+i, "prezime"+i), new Motor()));
		for(int i=5; i < 10; i++)
			listaVozila.add(new Kamion(new Vozac("ime"+i, "prezime"+i), new Motor()));
		for(int i=10; i < 15; i++)
			listaVozila.add(new Autobus(new Vozac("ime"+i, "prezime"+i), new Motor()));
		
		return listaVozila;
	}
	
	public ArrayList<Terminal> generisiListuTerminala(){
		
		ArrayList<Terminal> listaTerminala = new ArrayList<>();
		
		for(int i=0; i <3; i++){
			listaTerminala.add( new Terminal());
		}
		
		return listaTerminala;
	}
	
	public void pokreniSimulaciju(){
		for(var vozilo:listaVozila){
			vozilo.start();
		}
	}
	
	public static void main(String[] args){
		
		Simulacija simulacija = new Simulacija();
		
		System.out.println("TESTIRANJE I PROVJERA. Interesuje me da li se vozila ispravno generišu: ");
		simulacija.listaVozila.stream().forEach(System.out::println);
		
		simulacija.pokreniSimulaciju();		

		for(var ter:listaTerminala){
			ter.podnesiIzvjestaj();
		}
	}
}
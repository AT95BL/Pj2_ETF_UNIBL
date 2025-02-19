
import java.util.*;

public class Main{
	public static void main(String[] args){
		ArrayList<Klijent> listaKlijenata = new ArrayList<>();
		ArrayList<Transakcija> listaTransakcija = new ArrayList<>();
		
		Klijent pomK = new Klijent();
		listaKlijenata = pomK.generisiKlijente();
		
		Transakcija pomT = new Transakcija();
		listaTransakcija = pomT.generisiTransakcije();
		
		for(var t:listaTransakcija){
			t.start();
			
			try{
				t.join();
			}catch(Exception ex){
				ex.printStackTrace();
			}
			
			t.endTime = new Date().getTime();
			System.out.println("Trajanje transakcije: " + (t.endTime - t.startTime));
		}
	}
}
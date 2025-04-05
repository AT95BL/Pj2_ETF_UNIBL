
import java.util.Scanner;

public class JavaFabrika{
	
	public static boolean STATUS = true;
	
	public static void main(String[] args){
		
		MasinaZaVarenje lemilica = new MasinaZaVarenje();
		MasinaZaSjecenje flekserica = new MasinaZaSjecenje();
		
		Scanner scanner = new Scanner(System.in);
		String kontrolnaLinija = "";
		
		
		lemilica.start();
		flekserica.start();
			
		while(STATUS){
			kontrolnaLinija = scanner.nextLine();
			if("KRAJ".toLowerCase().equals(kontrolnaLinija.toLowerCase())){
				STATUS = false;
			}
		}
	}
}
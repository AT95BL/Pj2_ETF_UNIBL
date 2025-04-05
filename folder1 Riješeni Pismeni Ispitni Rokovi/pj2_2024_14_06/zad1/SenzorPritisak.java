
import java.util.List;
import java.util.ArrayList;
import java.util.stream.*;

public class SenzorPritisak extends Senzor{
	List<Double> listaPritisaka = new ArrayList<>();
	
	public double izracunajProsjecnuVrijednost(){
		/*
			double rezultat = 0;
			
			for(double pritisak:this.listaPritisaka){
				rezultat += pritisak;
			}
			
			return rezultat;
		*/
		
		// return this.listaPritisaka.stream().mapToDouble().average();
		
		return this.listaPritisaka.stream()
            .mapToDouble(Double::doubleValue) // Ispravljeno
            .average()
            .orElse(0.0); // Dodato za slučaj prazne liste
	}
}

import java.util.List;
import java.util.ArrayList;

public class SenzorVibracija extends Senzor{
	List<Double> listaVibracija = new ArrayList<>();
	
	public void prijaviProbleme(){
		for(int i=0; i < this.listaVibracija.size(); i++){
			if(i>0){
				double x = listaVibracija.get(i-1);
				double y = listaVibracija.get(i);
				
				if((2*x) == y){
					System.out.println("Opasnost!!");
				}
			}
		}
	}
}
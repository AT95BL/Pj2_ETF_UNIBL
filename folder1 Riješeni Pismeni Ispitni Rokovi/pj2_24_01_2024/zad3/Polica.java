
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Polica{
	public static int ID=0;
	int id;
	
	List<Knjiga> listaKnjiga = new ArrayList<>();
	
	int ukupanBrojKnjiga;
	
	// Constructor
	public Polica(){
		this.id = ++ID;
		
		Random random = new Random();
		this.ukupanBrojKnjiga = random.nextInt(20)+1;
		
		for(int i=0; i < ukupanBrojKnjiga; i++){
			this.listaKnjiga.add( new Knjiga() );
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Polica ").append(id).append(": \n");

		for (Knjiga knjiga : listaKnjiga) {
			sb.append("  - ").append(knjiga).append("\n"); // Svaka knjiga u novom redu
		}
		
		return sb.toString();
	}
}

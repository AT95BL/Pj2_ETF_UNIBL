
import java.util.List;
import java.util.ArrayList;

public class Sekcija{
	public static int ID=0;
	int id;
	
	public static final int BROJ_POLICA_PO_SEKCIJI=5;
	
	List<Polica> listaPolica = new ArrayList<>();
	
	// Constructor
	public Sekcija(){
		this.id = ++ID;
		
		for(int i=0; i < BROJ_POLICA_PO_SEKCIJI; i++){
			this.listaPolica.add( new Polica() );
		}
	}
	
	@Override
		public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Sekcija ").append(id).append(": \n");

		for (Polica polica : listaPolica) {
			sb.append(polica).append("\n"); // Svaka polica u novom redu
		}
		
		return sb.toString();
	}
}
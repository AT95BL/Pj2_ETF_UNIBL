
import java.util.List;
import java.util.ArrayList;

public class Biblioteka{
	
	List<Sekcija> listaSekcija = new ArrayList<>();
	
	public static final int BROJ_SEKCIJA=10;
	
	// Constructor
	public Biblioteka(){
		for(int i=0; i < BROJ_SEKCIJA; i++){
			this.listaSekcija.add( new Sekcija() );
		}
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Biblioteka: ");
		
		for(int i=0; i < this.listaSekcija.size(); i++){
			sb.append(listaSekcija.get(i));
		}
		
		return sb.toString();
	}
}

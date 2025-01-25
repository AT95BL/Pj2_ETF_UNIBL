
import java.util.List;
import java.util.ArrayList;

public class Paket<T extends Posiljka>{
	private static int GLOBAL_ID;
	int id;
	
	ArrayList<T> listaPosiljki = new ArrayList<>();
	int ukupnaTezinaPaketa = 0;
	
	// Constructor
	public Paket(){
		this.id = ++GLOBAL_ID;
	}
	
	// Constructor
	public Paket(ArrayList<T> listaPosiljki){
		this.listaPosiljki = listaPosiljki;
		this.id = ++GLOBAL_ID;
	}
	
	public void dodajPosiljkuUListuPosiljki(T posiljka){
		this.listaPosiljki.add(posiljka);
		this.ukupnaTezinaPaketa += posiljka.tezina;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Paket: \n");
		listaPosiljki.forEach((posiljka)->{sb.append(posiljka.toString() + "\n");});
		return sb.toString();
	}
}
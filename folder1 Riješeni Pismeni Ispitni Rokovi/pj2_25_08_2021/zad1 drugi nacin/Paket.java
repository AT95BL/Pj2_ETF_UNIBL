
import java.util.ArrayList;

public class Paket<T extends Posiljka>{
	ArrayList<T> listaPosiljki = new ArrayList<>();
	int tezinaPaketa = 0;
	
	public static int PAKET_ID = 0;
	int paketID;
	
	// Constructor
	public Paket(){
		this.paketID = ++PAKET_ID;
	}
	
	// Constructor
	public Paket(ArrayList<T> listaPosiljki){
		this.listaPosiljki=listaPosiljki;
		for(var posiljka:this.listaPosiljki){
			this.tezinaPaketa += posiljka.tezina;
		}
		this.paketID = ++PAKET_ID;
	}
	
	public void addPosiljka(T posiljka){
		this.listaPosiljki.add(posiljka);
		this.tezinaPaketa += posiljka.tezina;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		
		sb.append("Paket" + this.paketID + ": \n");
		
		for(var posiljka:this.listaPosiljki){
			sb.append(posiljka);
		}
		return sb.toString();
	}
}
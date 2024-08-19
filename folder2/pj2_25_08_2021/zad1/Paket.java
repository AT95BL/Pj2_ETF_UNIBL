import java.util.ArrayList;
	
public class Paket<T extends Posiljka>{
				//	 Ovdje T može biti bilo koja klasa koja nasljeđuje Posiljka
	
	ArrayList<T> posiljke = new ArrayList<>();
	int ukupnaTezina;
	
	public void addPosiljka(T posiljka){
		
		this.posiljke.add(posiljka);
		this.ukupnaTezina += posiljka.tezina;
	}
	
	@Override
	public String toString(){
		
		StringBuilder sb = new StringBuilder();
		sb.append("Paket: \n");
		posiljke.forEach((a)->{sb.append(a.toString()+"\n");});
		return sb.toString();
	}
	
}
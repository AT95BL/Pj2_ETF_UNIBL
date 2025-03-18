
import java.util.*;

public class PaketMakerNit extends Thread{
	
	ArrayList<Posiljka> listaPisama = new ArrayList<>(); 
	ArrayList<Posiljka> listaRazglednica = new ArrayList<>();
	ArrayList<Posiljka> listaVrijednosnihPosiljki = new ArrayList<>();
	
	// Constructor
	public PaketMakerNit(){
		
	}
	
	// Constructor
	public PaketMakerNit(ArrayList<Posiljka> listaPisama, ArrayList<Posiljka> listaRazglednica, ArrayList<Posiljka> listaVrijednosnihPosiljki){
		this.listaPisama = listaPisama;
		this.listaRazglednica = listaRazglednica;
		this.listaVrijednosnihPosiljki = listaVrijednosnihPosiljki;
	}
	
	Paket<Pismo> paketPisama = new Paket(listaPisama);
	Paket<Razglednica> paketRazglednica = new Paket(listaRazglednica);
	Paket<VrijednosnaPosiljka> paketVrijednosnihPosiljki = new Paket(listaVrijednosnihPosiljki);
	
	Random random = new Random();
	
	@Override
	public void run(){
		
		for(int i=0; i < 5; i++){
			
			int randomPismo = random.nextInt(listaPisama.size());
			int randomRazglednica = random.nextInt(listaRazglednica.size());
			int randomVrijednosnaPosiljka = random.nextInt(listaVrijednosnihPosiljki.size());
			
			paketPisama.addPosiljka((Pismo)listaPisama.get(randomPismo));
			listaPisama.remove(randomPismo);
			
			paketRazglednica.addPosiljka((Razglednica)listaRazglednica.get(randomRazglednica));
			listaRazglednica.remove(randomRazglednica);
			
			paketVrijednosnihPosiljki.addPosiljka((VrijednosnaPosiljka)listaVrijednosnihPosiljki.get(randomVrijednosnaPosiljka));
			listaVrijednosnihPosiljki.remove(randomVrijednosnaPosiljka);
		}
		
		ArrayList<ArrayList<? extends Posiljka>> kolekcija = new ArrayList<>();
		kolekcija.add(listaPisama);
		kolekcija.add(listaRazglednica);
		kolekcija.add(listaVrijednosnihPosiljki);
		
		ArrayList<Paket<? extends Posiljka>> paketi = new ArrayList<>();
		paketi.add(paketPisama);
		paketi.add(paketRazglednica);
		paketi.add(paketVrijednosnihPosiljki);
		
		SenderNit senderNit = new SenderNit(kolekcija, paketi);
		senderNit.start();
		try{
			senderNit.join();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
} 
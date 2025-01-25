
import java.util.ArrayList;
import java.util.Random;

public class PaketMakerNit extends Thread{
	public ArrayList<Razglednica> razglednice;
	public ArrayList<Pismo> pisma;
	public ArrayList<VrijednosnaPosiljka> vrijednosnePosiljke;
	
	// Constuctor
	public PaketMakerNit(ArrayList<Razglednica> razglednice,
						ArrayList<Pismo> pisma,
						ArrayList<VrijednosnaPosiljka> vrijednosnePosiljke)
	{
		this.razglednice=razglednice;
		this.pisma=pisma;
		this.vrijednosnePosiljke=vrijednosnePosiljke;
	}
	
	@Override
	public void run(){
		Paket<Razglednica> paketRazglednica = new Paket<>();
		Paket<Pismo> paketPisama = new Paket<>();
		Paket<VrijednosnaPosiljka> paketVrijednosnihPosiljki = new Paket<>();
		Random random = new Random();
		
		for(int i=0; i<5; i++){
			int pozicija = random.nextInt(razglednice.size());
			paketRazglednica.dodajPosiljkuUListuPosiljki(razglednice.get(pozicija));
			razglednice.remove(pozicija);
		}
		
		for(int i=0; i<5; i++){
			int pozicija = random.nextInt(pisma.size());
			paketPisama.dodajPosiljkuUListuPosiljki(pisma.get(pozicija));
			pisma.remove(pozicija);
		}
		
		for(int i=0; i<5; i++){
			int pozicija = random.nextInt(vrijednosnePosiljke.size());
			paketVrijednosnihPosiljki.dodajPosiljkuUListuPosiljki(vrijednosnePosiljke.get(pozicija));
			vrijednosnePosiljke.remove(pozicija);
		}
		
		ArrayList<ArrayList<? extends Posiljka>> kolekcijaPosiljki=new ArrayList<>();
		kolekcijaPosiljki.add(this.razglednice);
		kolekcijaPosiljki.add(this.pisma);
		kolekcijaPosiljki.add(this.vrijednosnePosiljke);
		
		ArrayList<Paket<? extends Posiljka>> paketi=new ArrayList<>();
		paketi.add(paketRazglednica); 
		paketi.add(paketPisama); 
		paketi.add(paketVrijednosnihPosiljki);
		
		
		SenderNit sn=new SenderNit(kolekcijaPosiljki,paketi);
		sn.start();
		
		try
		{
			sn.join();
		}catch(InterruptedException e){
			System.out.println("PREKID!!");
		}		
	}
}

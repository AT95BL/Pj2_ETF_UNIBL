import java.util.ArrayList;
import java.util.Random;

public class PaketMakerNit extends Thread
{
	public ArrayList<Razglednica> razglednice;
	public ArrayList<Pismo> pisma;
	public ArrayList<VrijednosnaPosiljka> vrijednosnePosiljke;
	
	public PaketMakerNit(ArrayList<Razglednica> razglednice,ArrayList<Pismo> pisma,ArrayList<VrijednosnaPosiljka> vrijednosnePosiljke)
	{
		this.razglednice=razglednice;
		this.pisma=pisma;
		this.vrijednosnePosiljke=vrijednosnePosiljke;
	}
	
	@Override
	public void run()
	{
		Paket<Razglednica> paket1=new Paket<>();
		Paket<Pismo> paket2=new Paket<>();
		Paket<VrijednosnaPosiljka> paket3=new Paket<>();
		Random rand=new Random();
		
		for(int i=1;i<=5;i++)
		{
			int pos=rand.nextInt(razglednice.size());
			paket1.addPosiljka(razglednice.get(pos));
			razglednice.remove(pos);
		}
		
		for(int i=1;i<=5;i++)
		{
			int pos=rand.nextInt(pisma.size());
			paket2.addPosiljka(pisma.get(pos));
			pisma.remove(pos);
		}
		
		for(int i=1;i<=5;i++)
		{
			int pos=rand.nextInt(vrijednosnePosiljke.size());
			paket3.addPosiljka(vrijednosnePosiljke.get(pos));
			vrijednosnePosiljke.remove(pos);
		}
		
		ArrayList<ArrayList<? extends Posiljka>> kolekcija=new ArrayList<>();
		kolekcija.add(this.razglednice);
		kolekcija.add(this.pisma);
		kolekcija.add(this.vrijednosnePosiljke);
		
		ArrayList<Paket<? extends Posiljka>> paketi=new ArrayList<>();
		paketi.add(paket1); 
		paketi.add(paket2); 
		paketi.add(paket3);
		
		SenderNit sn=new SenderNit(kolekcija,paketi);
		sn.start();
		
		try
		{
			sn.join();
		}
		catch(InterruptedException e)
		{
			System.out.println("PREKID!!");
		}	
	}
}

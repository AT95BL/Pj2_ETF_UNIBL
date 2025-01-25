
import java.util.Random;
import java.util.Date;

public abstract class Vozilo extends Thread
{
	public int id;
	public Vozac vozac;
	public Motor motor;
	public String konfiguracija;
	public int pozicija;
	public double brzina;
	public long start;
	public long end;
	public boolean zavrsio=true;;
	
	public Vozilo()
	{
		this.id=0;
		this.vozac=null;
		this.motor=null;
		this.konfiguracija="";
		this.pozicija=0;
		this.brzina=0;
	}
	
	public Vozilo(int id,Vozac vozac,Motor motor,String konfiguracija)
	{
		this.id=id;
		this.vozac=vozac;
		this.motor=motor;
		this.konfiguracija=konfiguracija;
		this.pozicija=0;
		this.brzina=100.0/(Integer.parseInt(konfiguracija));
	}
	
	public long getVrijemeKretanja(){return this.end-this.start;}
	
	@Override
	public String toString()
	{
		return "Vozilo "+this.id+" se nalazi na poziciji "+this.pozicija;
	}
	
	@Override
	public void run()
	{
		Random random=new Random();
		this.start=new Date().getTime();
		for(this.pozicija=0;this.pozicija<Simulacija.map.length;this.pozicija++)
		{
			System.out.println(this);
			double brz=this.brzina;
			if("NERAVNO".equals(Simulacija.map[pozicija]))
			{
				brz=this.brzina+(this.brzina/10.0);
				System.out.println(this+" se nalazi na neravnom polju i smanjio je brzinu");
			}
			else if("KLIZAVO".equals(Simulacija.map[pozicija]))
			{
				int num=random.nextInt(100);
				if(num<Simulacija.SansaZaPrevrtanje)
				{
					System.out.println(this+" se prevrnulo");
					this.zavrsio=false;
					break;
				}
			}
			try
			{
				//long tmp=(long)(brz*1000.0);
				sleep((long)(brz*1000.0));
			}
			catch(InterruptedException e)
			{
				System.out.println("PREKID!!");
			}
		}
		this.end=new Date().getTime();
	}
}
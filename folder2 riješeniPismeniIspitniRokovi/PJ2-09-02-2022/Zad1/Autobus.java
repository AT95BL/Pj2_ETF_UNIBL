
public class Autobus extends Vozilo
{
	public int brojSjedista;
	public Autobus()
	{
		super();
		this.brojSjedista=0;
	}
	
	public Autobus(int id,Vozac vozac,Motor motor,String konfiguracija,int brojSjedista)
	{
		super(id,vozac,motor,konfiguracija);
		this.brojSjedista=brojSjedista;
	}
}
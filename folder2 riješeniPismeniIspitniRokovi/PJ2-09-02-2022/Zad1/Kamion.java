
public class Kamion extends Vozilo implements IPrevozTereta
{
	public Kamion()
	{
		super();
	}
	
	public Kamion(int id,Vozac vozac,Motor motor,String konfiguracija)
	{
		super(id,vozac,motor,konfiguracija);
	}
}

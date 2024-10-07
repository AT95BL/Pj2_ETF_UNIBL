
public class Automobil extends Vozilo implements IHaveSuperMoci
{
	public Automobil()
	{
		super();
	}
	
	public Automobil(int id,Vozac vozac,Motor motor,String konfiguracija)
	{
		super(id,vozac,motor,konfiguracija);
	}
}
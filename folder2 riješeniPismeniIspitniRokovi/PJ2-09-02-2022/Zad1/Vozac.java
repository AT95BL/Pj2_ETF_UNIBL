
public class Vozac
{
	public String ime,prezime;
	public Vozac()
	{
		this.ime="";
		this.prezime="";
	}
	
	public Vozac(String ime,String prezime)
	{
		this.ime=ime;
		this.prezime=prezime;
	}
	
	@Override
	public String toString()
	{
		return this.ime+", "+this.prezime;
	}
}
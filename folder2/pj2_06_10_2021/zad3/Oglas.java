
import java.util.Date;

enum KategorijaPosla
{
	IT,EKONOMIJA,MEDICINA,NOVINARSTVO,PRAVO;
}

public class Oglas
{
	public String naziv;
	public String kratkiOpis;
	public Date datumObjavljivanja;
	public int vrijemeTrajanjaOglasa;
	public int plata;
	public int brojGodinaRadnogIskustva;
	public String grad;
	public KategorijaPosla kategorija;
	
	// Konstruktor
	public Oglas()
	{
		this.naziv=this.kratkiOpis=this.grad="";
		this.datumObjavljivanja=null;
		this.vrijemeTrajanjaOglasa=this.plata=this.brojGodinaRadnogIskustva=0;
		this.kategorija=null;
	}
	
	// get -metode
	public Date getDate(){return this.datumObjavljivanja;}
	public Double getPlata(){return (double)this.plata;}
	public String getGrad(){return this.grad;}
	public KategorijaPosla getKategorija(){return this.kategorija;}
	public int getGodineIskustva(){return this.brojGodinaRadnogIskustva;}
	
	// Konstruktor
	public Oglas(String naziv,
		String kratkiOpis,
		Date datumObjavljivanja,
		int vrijemeTrajanjaOglasa,
		int plata,
		int brojGodinaRadnogIskustva,
		String grad,
		KategorijaPosla kategorija)
	{
		this.naziv=naziv;
		this.kratkiOpis=kratkiOpis;
		this.datumObjavljivanja=datumObjavljivanja;
		this.vrijemeTrajanjaOglasa=vrijemeTrajanjaOglasa;
		this.plata=plata;
		this.brojGodinaRadnogIskustva=brojGodinaRadnogIskustva;
		this.grad=grad;
		this.kategorija=kategorija;
	}
	
	@Override
	public String toString()
	{
		return this.naziv+","+this.kratkiOpis+","+this.datumObjavljivanja+","+this.vrijemeTrajanjaOglasa+", "+this.plata+
			", "+this.brojGodinaRadnogIskustva+", "+this.grad+", "+this.kategorija;
	}
}

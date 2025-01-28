
public class Film
{
	public String naziv;
	public int godinaObjavljivanja;
	public int budzet;
	public double ocjena;
	
	// Constructor
	public Film()
	{
		this.naziv="";
		this.godinaObjavljivanja=this.budzet=0;
		this.ocjena=0;
	}

	// Constructor
	public Film(String naziv,int godinaObjavljivanja,int budzet,double ocjena)
	{
		this.naziv=naziv;
		this.godinaObjavljivanja=godinaObjavljivanja;
		this.budzet=budzet;
		this.ocjena=ocjena;
	}
	
	public int getGodinaObjavljivanja()
	{
		return this.godinaObjavljivanja;
	}
	
	public int getBudzet(){
		return this.budzet;
	}
	
	public double getOcjena(){
		return this.ocjena;
	}
	
	@Override
	public String toString()
	{
		return this.naziv+", "+this.godinaObjavljivanja+", "+this.budzet+", "+this.ocjena;
	}
	
	@Override
	public boolean equals(Object other)
	{
		if(!(other instanceof Film))
			return false;
		Film tmp=(Film)other;
		return this.naziv.equals(tmp.naziv) && this.godinaObjavljivanja==tmp.godinaObjavljivanja;
	}
	
	@Override
	public int hashCode()
	{
		int hash=3;
		hash=hash*7+this.naziv.hashCode();
		hash=hash*7+this.godinaObjavljivanja;
		return hash;
	}
}
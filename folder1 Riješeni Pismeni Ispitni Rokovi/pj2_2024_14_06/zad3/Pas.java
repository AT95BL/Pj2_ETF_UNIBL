
import java.util.Random;
import java.util.Objects;

public class Pas{
	public static int ID=0;
	int id;
	
	int godinaRodjenja;
	String ime;
	double tezina;
	OmiljenaHrana omiljenaHrana;
	
	Random random = new Random();
	
	// Constructor
	public Pas(){
		this.id = ++ID;
		this.godinaRodjenja = 2010 + this.id;
		this.ime = "Ime" + this.id;
		this.tezina = 15.2 + this.id;
		
		int slucajanBroj = random.nextInt(3);
		this.omiljenaHrana = OmiljenaHrana.values()[slucajanBroj];
	}
	
	@Override
	public String toString(){
		return "{" + this.ime + ", " + this.godinaRodjenja + ", " + this.tezina + "}";
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj.getClass() != this.getClass() || (obj == null))
			return false;
		if(this == obj)
			return true;
		
		Pas pas = (Pas)obj;
		
		return this.godinaRodjenja == pas.godinaRodjenja && this.ime.equals(pas.ime);
	}
	
	@Override
	public int hashCode(){
		return Objects.hash(this.godinaRodjenja, this.ime);
	}
	
	public int getGodinaRodjenja(){
		return this.godinaRodjenja;
	}
}
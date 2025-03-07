
public class Knjiga{
	public static int ID=0;
	int id;
	
	String naslov = "";
	Autor autor = null;
	
	// Constructor
	public Knjiga(){
		this.id = ++ID;
		this.naslov = "Knjiga" + this.id;
		this.autor = new Autor();
	}
	
	@Override
	public String toString(){
		return this.naslov;
	}
}
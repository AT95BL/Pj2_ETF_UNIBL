
import java.util.Objects;

public class Autor{
	
	public static int ID = 0;
	int id;
	
	String ime;
	String prezime;
	
	// Constructor --ZNACI, SVE AUTOMATIZUJ!!
	public Autor(){
		this.id = ++ID;
		this.ime = "Ime" + this.id;
		this.prezime = "Prezime" + this.id;
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj == null || (obj.getClass() != this.getClass())){
			return false;
		
		}else if(this == obj){
			return true;
		}
				
		Autor autor = (Autor)obj;
		return autor.ime.equals(this.ime) && autor.prezime.equals(this.prezime);
	}
	
	@Override
	public int hashCode(){
		return Objects.hash(ime, prezime);
	}
	
	@Override
	public String toString(){
		return "Autor{ " + this.ime + " " + this.prezime + " }";
	}
}
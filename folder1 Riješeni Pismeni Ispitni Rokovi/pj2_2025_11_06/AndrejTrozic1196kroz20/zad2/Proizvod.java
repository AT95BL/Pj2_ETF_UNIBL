
import java.util.*;

public class Proizvod{
	String naziv;
	double cijena;
	int kolicina;
	
	Random random = new Random();
	static int ID=1;
	int id;
	
	public Proizvod(){
		this.id = ID++;
		this.naziv = "Proizvod" + this.id;
		this.cijena = this.id;
		this.kolicina = this.id;
	}
	
	@Override
	public String toString(){
		return this.naziv + " " + this.cijena + " " + this.kolicina;
	}
}
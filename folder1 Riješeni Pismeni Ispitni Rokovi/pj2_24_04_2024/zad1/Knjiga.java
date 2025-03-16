
import java.util.Random;

public class Knjiga{
	
	static int ID = 1990;
	int id;
	
	String naslov;
	String autor;
	int brojStranica;
	int godinaIzdavanja;
	
	int koordinataX;
	int koordinataY;
	
	Random random = new Random();
	
	// Constructor
	public Knjiga(){
		this.id = ID++;
		this.naslov = "Naslov" + this.id;
		this.autor = "Autor" + this.id;
		this.brojStranica = this.id / 4;
		this.godinaIzdavanja = this.id;
		
		// Postavi na Mapu
		do{
			this.koordinataX = random.nextInt(Main.BROJ_VRSTA);
			this.koordinataY = random.nextInt(Main.BROJ_KOLONA);
		}while(Main.mapa[this.koordinataX][this.koordinataY] != null);
		
		Main.mapa[this.koordinataX][this.koordinataY] = this;
	}
	
	@Override
	public String toString(){
		return "{" + this.naslov + ", " + this.autor + ", " + this.brojStranica + ", " + this.godinaIzdavanja + "}";
	}
}
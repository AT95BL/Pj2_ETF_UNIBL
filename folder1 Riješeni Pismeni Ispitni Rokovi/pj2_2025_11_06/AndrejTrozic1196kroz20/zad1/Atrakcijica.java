
import java.util.*;

public abstract class Atrakcijica extends Thread{
	public static int GLOBAL_ID=0;
	int id;
	
	String nazivNekeAtrakcije = "";
	
	int koordinataX;
	int koordinataY;
	int koordinataZ;
	
	Random random = new Random();
	
	int brojPosjetilaca;
	List<Posjetilac> listaPosjetilaca = new ArrayList<>();
	
	String naziv = "";
	
	// Constructor
	public Atrakcijica(){
		this.id = ++GLOBAL_ID;
		generisiKoordinate();
		Main.matrica[koordinataX][koordinataY][koordinataZ] = this;
	}
	
	public void generisiKoordinate(){
		
		int x,y,z;
		x = y = z = 0;
		
		while(Main.matrica[x][y][z] != null){
			x = random.nextInt(Main.X);
			y = random.nextInt(Main.Y);
			z = random.nextInt(Main.Z);
		}
		
		this.koordinataX = x;
		this.koordinataY = y;
		this.koordinataZ = z;
	}
	
	@Override
	public void run(){}
	
	@Override
	public String toString(){
		String str = "";
		str += this.id;
		return str;
	}
}
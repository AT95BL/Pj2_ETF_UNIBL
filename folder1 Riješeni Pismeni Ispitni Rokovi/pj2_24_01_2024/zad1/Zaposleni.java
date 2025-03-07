
import java.util.*;

public abstract class Zaposleni extends Thread{
	
	public static int ID=0;
	int id;
	
	String ime;
	String prezime;
	int godineRadaUKompaniji;
	double cijenaRada;
	
	List<Zadatak> listaUradjenihZadataka = new ArrayList<>();
	int brojZadatakaUListi = 0;
	
	// Constructor
	public Zaposleni(){
		this.id = ++ID;
		this.ime = "Ime" + this.id;
		this.prezime = "Pre" + this.id;
		
		Random random = new Random();
		this.godineRadaUKompaniji = random.nextInt(20)+1;
		
		this.cijenaRada = random.nextDouble(15)+1.20;
	}
	
	public abstract void generisiZadatak();
	
	public void pauza(){
		if(this.id == (Main.endTime - Main.startTime)){
			System.out.println("PAUZA!! \n");
			
			try{
				Thread.sleep(5000);
			
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
	}
	
	@Override
	public String toString(){
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("Radnik: " + this.ime + " " + this.prezime + "\n" +
					"Godine Rada u Kompaniji: " + this.godineRadaUKompaniji + "\n" +
					"Cijena rada: " + this.cijenaRada + "\n");
					
		sb.append("Zadaci: \n");
		for(int i=0; i < this.listaUradjenihZadataka.size(); i++){
			sb.append(listaUradjenihZadataka.get(i));
		}
		sb.append("\n");
		
		return sb.toString();
	}
}
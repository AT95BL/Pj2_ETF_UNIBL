
import java.util.ArrayList;
import java.io.*;

public class RazvrstavanjeNit extends Thread{
	public static final File SERIALIZATION_FOLDER = new File("./serijalizacija");
	
	ArrayList<Posiljka> kolekcijaPosiljki = new ArrayList<>();
	
	// Constructor
	public RazvrstavanjeNit(ArrayList<Posiljka> kolekcijaPosiljki){
		this.kolekcijaPosiljki = kolekcijaPosiljki;
	}
	
	static{
		try{
			if(!SERIALIZATION_FOLDER.exists()){
				SERIALIZATION_FOLDER.mkdir();
			}
		}catch(Exception ex){
			ex.printStackTrace();
			System.exit(-1);
		}
	}
	
	public void serijalizuj(ArrayList<? extends Posiljka> listaPosiljki, String nazivIzlazneDatoteke){
		try{
			ObjectOutputStream output = new ObjectOutputStream(
										new BufferedOutputStream(
										new FileOutputStream(SERIALIZATION_FOLDER + File.separator + nazivIzlazneDatoteke)));
			output.writeObject(listaPosiljki);
			output.flush();
			output.close();
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	@Override
	public void run(){
		ArrayList<Razglednica> razglednice = new ArrayList<>();
		ArrayList<Pismo> pisma = new ArrayList<>();
		ArrayList<VrijednosnaPosiljka> vrijednosnePosiljke = new ArrayList<>();
		
		for(var posiljka:kolekcijaPosiljki){
			if(posiljka instanceof Razglednica){
				razglednice.add((Razglednica)posiljka);
			}
			else if(posiljka instanceof Pismo){
				pisma.add((Pismo)posiljka);
			}
			else{
				vrijednosnePosiljke.add((VrijednosnaPosiljka)posiljka);
			}
		}
		
		serijalizuj(razglednice, "razglednice.ser");
		serijalizuj(pisma, "pisma.ser");
		serijalizuj(vrijednosnePosiljke, "vrijednosnePosiljke.ser");
		
		
		PaketMakerNit pmk = new PaketMakerNit(razglednice, pisma, vrijednosnePosiljke);
		pmk.start();
		try{
			pmk.join();
		}catch(InterruptedException ex){
			ex.printStackTrace();
		}		
	}
}
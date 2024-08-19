import java.util.ArrayList;
import java.io.*;

public class RazvrstavanjeNit extends Thread{
	
	ArrayList<Posiljka> posiljke = new ArrayList<>();
	
	public static final File SERIALIZATION_FOLDER=new File("./serijalizacija");
	
	public RazvrstavanjeNit(ArrayList<Posiljka> posiljke){
		this.posiljke = posiljke;
	}
	
	static{
		
		try{
			if(!SERIALIZATION_FOLDER.exists())
				SERIALIZATION_FOLDER.mkdir();
		}
		catch(Exception ex){
			ex.printStackTrace();
			System.exit(-1);
		}
	}
	
	private void serijalizuj(ArrayList<? extends Posiljka> listaNekihPosiljki, String name){
		
		try{
			
			ObjectOutputStream output = new ObjectOutputStream(new BufferedOutputStream( new FileOutputStream(SERIALIZATION_FOLDER + File.separator + name)));
			output.writeObject(listaNekihPosiljki);
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
		
		for(var el:posiljke){
			
			if(el instanceof Razglednica){
				razglednice.add((Razglednica)el);
			}
			else if(el instanceof Pismo){
				pisma.add((Pismo)el);
			}
			else if(el instanceof VrijednosnaPosiljka){
				vrijednosnePosiljke.add((VrijednosnaPosiljka)el);
			}
		}
		
		serijalizuj(razglednice, "razglednice.ser");
		serijalizuj(pisma, "pisma.ser");
		serijalizuj(vrijednosnePosiljke, "vrijednosnePosiljke.ser");
		
		PaketMakerNit pmk = new PaketMakerNit(razglednice, pisma, vrijednosnePosiljke);
		pmk.start();
		try{
			pmk.join();
		}
		catch(InterruptedException ex){
			ex.printStackTrace();
		}	
	}
}
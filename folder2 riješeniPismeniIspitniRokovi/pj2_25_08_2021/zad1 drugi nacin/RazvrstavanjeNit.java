
import java.util.*;
import java.io.*;

public class RazvrstavanjeNit extends Thread{
	
	ArrayList<Posiljka> listaPosiljki = new ArrayList<>();
	
	ArrayList<Posiljka> listaRazglednica = new ArrayList<>();
	ArrayList<Posiljka> listaPisama = new ArrayList<>();
	ArrayList<Posiljka> listaVrijednosnihPosiljki = new ArrayList<>(); 
	
	// ------------------------------------------------------------------------------------------
		public static final File SERIALIZATION_FOLDER=new File("./serijalizacija");
		
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
	
		public void serijalizuj(ArrayList<? extends Posiljka> listaPosiljki, String nazivFajla){
			try{
				
				ObjectOutputStream output = new ObjectOutputStream(
					new BufferedOutputStream( 
					new FileOutputStream(SERIALIZATION_FOLDER + File.separator + nazivFajla)
					));
				output.writeObject(listaPosiljki);
				output.flush();
				output.close();
				
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
	
	// -------------------------------------------------------------------------------------------
	
	// Constructor
	public RazvrstavanjeNit(){
		
	} 
	
	// Constructor
	public RazvrstavanjeNit(ArrayList<Posiljka> listaPosiljki){
		this.listaPosiljki = listaPosiljki;
	}
	
	@Override
	public void run(){
		
		for(var posiljka:this.listaPosiljki){
			
			if(posiljka instanceof Pismo){
				listaPisama.add(posiljka);
				System.out.println("Svrstaj pismo \n");
			
			}else if(posiljka instanceof Razglednica){
				listaRazglednica.add(posiljka);
				System.out.println("Svrstaj razglednicu \n");
			
			}else{
				listaVrijednosnihPosiljki.add(posiljka);
				System.out.println("Svrstaj vrijednosnu posiljku \n");
			}
		}
		
		serijalizuj(listaPisama, "pisma.ser");
		serijalizuj(listaRazglednica, "razglednice.ser");
		serijalizuj(listaVrijednosnihPosiljki, "vrijednosnePosiljke.ser");
			
		PaketMakerNit paketMakerNit = new PaketMakerNit(listaPisama, listaRazglednica, listaVrijednosnihPosiljki);
		paketMakerNit.start();
		try{
			paketMakerNit.join();
		}catch(InterruptedException ex){
			ex.printStackTrace();
		}
	}
}

import java.util.List;
import java.util.ArrayList;
import java.nio.file.*;
import java.io.*;

public class VoziloParser extends Parser<SuperVozilo>{
	
	// Constructor
	public VoziloParser(Path path){
		super(path);
	}
	
	@Override
	public ArrayList<SuperVozilo> importFromFile()throws IOException{
		ArrayList<SuperVozilo> listaVozila=new ArrayList<>();
		
		List<String> sveLinijeDatoteke=null;
		try{
		 sveLinijeDatoteke=this.procitajSveLinijeDatoteke();	
		}catch(IOException ex){
			ex.printStackTrace();
		}
		
		for(String jednaLinijaDatoteke:sveLinijeDatoteke){
				System.out.println(jednaLinijaDatoteke);
			try{
				String[] sveRijeciJedneLinijeDatoteke=this.procitajSveRijeciJedneLinijeDatoteke(jednaLinijaDatoteke, " ");
				
				for(var tmp:sveRijeciJedneLinijeDatoteke){
					System.out.println(tmp);
				}
				
				if("Automobil".equalsIgnoreCase(sveRijeciJedneLinijeDatoteke[0])){
					listaVozila.add(new Automobil(Integer.parseInt(sveRijeciJedneLinijeDatoteke[1]), 
						new Vozac(sveRijeciJedneLinijeDatoteke[2], sveRijeciJedneLinijeDatoteke[3]),
						Motor.valueOf(sveRijeciJedneLinijeDatoteke[4]),
						sveRijeciJedneLinijeDatoteke[5]));
						
				}else if("Kamion".equalsIgnoreCase(sveRijeciJedneLinijeDatoteke[0])){
					listaVozila.add(new Kamion(Integer.parseInt(sveRijeciJedneLinijeDatoteke[1]), 
					new Vozac(sveRijeciJedneLinijeDatoteke[2], sveRijeciJedneLinijeDatoteke[3]),
					Motor.valueOf(sveRijeciJedneLinijeDatoteke[4]),
					sveRijeciJedneLinijeDatoteke[5]));
					
				}else if("Autobus".equalsIgnoreCase(sveRijeciJedneLinijeDatoteke[0])){
					listaVozila.add(new Autobus(Integer.parseInt(sveRijeciJedneLinijeDatoteke[1]), 
					new Vozac(sveRijeciJedneLinijeDatoteke[2], sveRijeciJedneLinijeDatoteke[3]),
					Motor.valueOf(sveRijeciJedneLinijeDatoteke[4]),
					sveRijeciJedneLinijeDatoteke[5]));
					
				}else{
					System.err.println("Nedefinisano...");
				}
				
			}catch(IllegalArgumentException | IndexOutOfBoundsException ex){
				ex.printStackTrace();
			}
		}
		return listaVozila;
	}
}
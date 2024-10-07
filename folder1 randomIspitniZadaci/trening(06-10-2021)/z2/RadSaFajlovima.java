
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;
import java.nio.file.*;

public class RadSaFajlovima{
	
	public static void pronadjiRijeciUFajlovima(ArrayList<String> rijeci, Path... paths){
		// prvo, prolazis kroz datoteke..
		for(var path:paths){
			try{
					// A/B/C/D ->	A/B/C/	"D.search.txt"
				String fileName=path.getFileName().toString()+"search.txt";
				// A/B/C/D -> A/B/C/D.search.txt
				PrintWriter printWriter=new PrintWriter(new BufferedWriter(new FileWriter(path.getParent().toString()+fileName)));
				
				List<String> sveLinijeDatoteke=Files.readAllLines(path);
				
				for(var jednaLinijaDatoteke:sveLinijeDatoteke){
					
					var sveRijeciJedneLinijeDatoteke=jednaLinijaDatoteke.split("//W+");
					for(var jednaRijecDatoteke:sveRijeciJedneLinijeDatoteke){
						
						for(var glavneRijeci:rijeci){
							if(jednaRijecDatoteke.equalsIgnoreCase(glavneRijeci)){
								printWriter.println(jednaRijecDatoteke);
								break;
							}
						}
					}
				}
				
				printWriter.flush();
				printWriter.close();
				
			}catch(IOException ex){
				ex.printStackTrace();
			}
		}
	}
	
	public static void prebrojRijeci(Path path){
		HashMap<String,Integer> map=new HashMap<>();
		try{
			List<String> sveLinijeDatoteke=Files.readAllLines(path);
			for(String jednaLinijaDatoteke:sveLinijeDatoteke){
				
				String[] sveRijeciJedneLinijeDatoteke=jednaLinijaDatoteke.split("//W+");
				for(String jednaRijecDatoteke:sveRijeciJedneLinijeDatoteke){
					if(map.containsKey(jednaRijecDatoteke)){
						map.put(jednaRijecDatoteke, map.get(jednaRijecDatoteke)+1);
					}else{
						map.put(jednaRijecDatoteke, 1);
					}
				}
			}
			
		}catch(IOException ex){
			ex.printStackTrace();
		}
		System.out.println("Rijeci u fajlu i ponavljanja: ");
		map.entrySet().forEach((s)->{System.out.println(s.getKey() + "--" + s.getValue());});
	}
	
	public static void zamjeniRijeciUFajlu(Path path, HashMap<String, String> rijecnik) {
		try {
			// Učitaj sve linije iz datoteke
			List<String> sveLinijeDatoteke = Files.readAllLines(path);
			
			// Otvori fajl za pisanje
			PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(path.toString())));
			
			// Prođi kroz svaku liniju datoteke
			for (String jednaLinijaDatoteke : sveLinijeDatoteke) {
				// Podijeli liniju na riječi
				String[] sveRijeciJedneLinijeDatoteke = jednaLinijaDatoteke.split("\\W+");
				String novi = new String(jednaLinijaDatoteke);
				
				// Prođi kroz svaku riječ u liniji
				for (String jednaRijecDatoteke : sveRijeciJedneLinijeDatoteke) {
					// Ako postoji zamjena u rječniku, zamijeni riječ
					if (rijecnik.containsKey(jednaRijecDatoteke)) {
						novi = novi.replaceAll("\\b" + jednaRijecDatoteke + "\\b", rijecnik.get(jednaRijecDatoteke));
					}
				}
				
				// Zapiši zamijenjenu liniju u datoteku
				printWriter.println(novi);
			}
			
			// Zatvori pisac
			printWriter.flush();
			printWriter.close();
		} catch (IOException ex) {
			System.out.println("Greska prilikom otvaranja fajla: " + path);
			ex.printStackTrace();
		}
	}
}
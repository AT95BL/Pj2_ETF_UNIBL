import java.util.*;
import java.io.*;
import java.nio.file.*;


public class Main{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		String line = "";
		Path putanjaUlazneDatoteke;
		
		System.out.println("Unesite putanju ulazne datoteke: ");
		line = scanner.nextLine();
		putanjaUlazneDatoteke = Paths.get(line);
		
		List<String> sveLinijeUlazneDatoteke = new ArrayList<>();
		try{
			sveLinijeUlazneDatoteke = Files.readAllLines(putanjaUlazneDatoteke);
		}catch(IOException ex){
			System.out.println("Citanje nije uspjelo..");
			ex.printStackTrace();
		}
		
		Map<String, String> mapa = new HashMap<>();
		
		boolean control=true;
		for(String linijaDatoteke:sveLinijeUlazneDatoteke){
			String[] rijeciDatoteke = linijaDatoteke.split(";");
			
			if(control){
				control=false;
				System.out.println("Preskoci prvu liniju ..");
				continue;
			}
	
			
			if(mapa.get(rijeciDatoteke[0]) == null){
				mapa.put(rijeciDatoteke[0], new String(rijeciDatoteke[1] + ":" + rijeciDatoteke[2]));
			}else{
				String str = mapa.get(rijeciDatoteke[0]) + " " + rijeciDatoteke[1] + ":" + rijeciDatoteke[2];
				mapa.put(rijeciDatoteke[0], str);
			}
		}
		
		try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("izlaznaDatoteka.txt")))){
			for(Map.Entry<String,String> entry:mapa.entrySet()){
				String key = entry.getKey();
				String val = entry.getValue();
				String res = key + " -- " + val;
				
				pw.println(res);
			}
		}catch(IOException ex){
			System.out.println("Pisanje nije uspjelo..");
			ex.printStackTrace();
		}
	}
}
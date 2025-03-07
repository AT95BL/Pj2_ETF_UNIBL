
import java.util.*;

// zbog upisavanja podataka u fajl
import java.io.*;
import java.nio.file.*;

public class Main{
	
	public static long startTime = 0;
	public static long endTime = 0;
	
	public static boolean trajanjeSimulacije = true;
	
	public static List<Zaposleni> generisiRadnike(){
		
		List<Zaposleni> listaZaposlenika = new ArrayList<>();
		
		for(int i=0; i < 5; i++){
			listaZaposlenika.add(new RadnikNabavke());
		}
		
		for(int i=0; i < 10; i++){
			listaZaposlenika.add(new RadnikProdaje());
		}
		
		listaZaposlenika.add(new Racunovodja());
		
		return listaZaposlenika;
	}
	
	public static void main(String[] args){
		
		List<Zaposleni> listaZaposlenika = generisiRadnike();
		
		startTime = new Date().getTime();
		for(var zaposleni : listaZaposlenika){
			zaposleni.start();
			
			/*
			try{
				zaposleni.join();
			
			}catch(Exception ex){
				ex.printStackTrace();
			}
			*/
		}
		
		Scanner scanner = new Scanner(System.in);
		String linija = "";
		do{
			linija = scanner.nextLine();
			
			if("KRAJ".equalsIgnoreCase(linija)){
				trajanjeSimulacije = false;
			}
			
			endTime = new Date().getTime();
			
		}while(!"KRAJ".equalsIgnoreCase(linija));
		
		System.out.println("Trajanje simulacije: " + (endTime - startTime) + "[ms]");
		
		// -----------------------------------------------------------------------------------------------------------------------------
		Racunovodja direktor = new Racunovodja();
		
		System.out.println("Unesite putanju izlazne datoteke: ");
		linija = scanner.nextLine();
		Path putanjaIzlazneDatoteke = Paths.get(linija);
		
		try (BufferedWriter writer = Files.newBufferedWriter(putanjaIzlazneDatoteke, StandardOpenOption.APPEND, StandardOpenOption.CREATE)) {
            for (int i = 0; i < listaZaposlenika.size(); i++) {
				writer.write(listaZaposlenika.get(i).toString());
				writer.newLine();
				writer.write(String.valueOf(direktor.izracunajDnevnicu(listaZaposlenika.get(i))));
				writer.newLine();
			}
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
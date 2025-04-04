
import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class BrojacRijeci implements FileVisitor<Path>{
	public static int BROJ_POZIVA=0;
	
	Path putanjaPocetnogDirektorijuma = null;
	int duzinaRijeci = 0;
	
	Map<Path, Integer> mapa = new HashMap<>();
	
	// Constructor
	public BrojacRijeci(Path putanjaPocetnogDirektorijuma, int duzinaRijeci){
		this.putanjaPocetnogDirektorijuma = putanjaPocetnogDirektorijuma;
		this.duzinaRijeci = duzinaRijeci;
	}
	
	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException ex)throws IOException{ 
		return FileVisitResult.CONTINUE; 
	}
		
	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)throws IOException{ 
		return FileVisitResult.CONTINUE; 
	}
		
	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

		if (file.getFileName().toString().endsWith(".txt")) {

			System.out.println(file.getFileName().toString() + " je pronađen..");

			try {
				List<String> sveLinijeDatoteke = Files.readAllLines(file);

				for (String jednaLinijaDatoteke : sveLinijeDatoteke) {

					String[] rijeci = jednaLinijaDatoteke.split(" ");

					for (String rijec : rijeci) {
						mapa.put(file, rijec.length());
					}
				}
			} catch (IOException e) {
				System.err.println("Greška prilikom čitanja datoteke " + file.getFileName() + ": " + e.getMessage());
				e.printStackTrace();
			} catch (Exception e) {
				System.err.println("Neočekivana greška prilikom obrade datoteke " + file.getFileName() + ": " + e.getMessage());
				e.printStackTrace();
			}
		}
		return FileVisitResult.CONTINUE;
	}
		
	@Override
	public FileVisitResult visitFileFailed(Path file, IOException exc)throws IOException{ 
		return FileVisitResult.CONTINUE; 
	}
	
	public void printResult(){
		try{
			BROJ_POZIVA++;
			String nazivIzlazneDatoteke = "Rezultat" + BROJ_POZIVA + ".txt";
			File izlaznaDatoteka = new File(nazivIzlazneDatoteke);
			
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(izlaznaDatoteka)));
			
			for(Map.Entry<Path, Integer> entry : this.mapa.entrySet()){
				String key = entry.getKey().toString();
				String value = entry.getValue().toString();
				
				if(value.length() == this.duzinaRijeci){
					pw.println(key + ": " + value);
				}
			}
			
			pw.close();

		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
} 
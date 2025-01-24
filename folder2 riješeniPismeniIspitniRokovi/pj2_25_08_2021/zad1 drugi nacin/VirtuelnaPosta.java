
import java.util.*;

public class VirtuelnaPosta{
	
	public static long START_TIME=0;
	public static long END_TIME=0;
	
	ArrayList<Posiljka> listaPosiljki = new ArrayList<>();
	
	public static ArrayList<Posiljka> kreirajListuPosiljki(){
		ArrayList<Posiljka> listaPosiljki = new ArrayList<>();
		for(int i=0; i < 15; i++){
			
			try{
				Razglednica razglednica = new Razglednica("p"+(i+1), "p"+(i+1), "s"+(i+1), ".png");
				listaPosiljki.add(razglednica);
			}catch(Exception ex){
				ex.printStackTrace();
			}
			
			Pismo pismo = new Pismo("p"+(i+1), "p"+(i+1), "s"+(i+1));
			listaPosiljki.add(pismo);
			
			Random random = new Random();
			Valuta randomValuta = Valuta.values()[random.nextInt(Valuta.values().length)];
			VrijednosnaPosiljka vrijednosnaPosiljka = new VrijednosnaPosiljka("p"+(i+1), "p"+(i+1), randomValuta);
			listaPosiljki.add(vrijednosnaPosiljka);
		}
		
		return listaPosiljki;
	}
	
	public static void main(String[] args){
		
		ArrayList<Posiljka> listaPosiljki = new ArrayList<>();
		listaPosiljki = kreirajListuPosiljki();
		
		for(var posiljka: listaPosiljki){
			System.out.println(posiljka);
		}
		
		Collections.shuffle(listaPosiljki);
		
		System.out.println("Nakon poziva shuffle metode: ");
		for(var posiljka: listaPosiljki){
			System.out.println(posiljka);
		}
		
		
		RazvrstavanjeNit razvrstavanjeNit = new RazvrstavanjeNit(listaPosiljki);
		START_TIME = new Date().getTime();
		razvrstavanjeNit.start();
		try{
			razvrstavanjeNit.join();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		System.out.println("Vrijeme trajanja simulacija: " + (END_TIME - START_TIME) + "\n");
		// ------------------------------------------------------------------------------------------
			var files=RazvrstavanjeNit.SERIALIZATION_FOLDER.listFiles();
			for(var file:files)
			{
				System.out.println(file.getAbsolutePath());
				System.out.println(file.length()+"[B]");
			}
		// ------------------------------------------------------------------------------------------		
	}
}
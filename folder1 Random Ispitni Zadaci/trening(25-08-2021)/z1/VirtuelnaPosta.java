
import java.util.ArrayList;
import java.util.Random;
import java.util.Date;
import java.util.Collections;

public class VirtuelnaPosta{
	static Random random = new Random();
	public static long startTime=0;
	public static long endTime=0;
	
	public static ArrayList<Razglednica> generisiListuRazglednica(){
		ArrayList<Razglednica> listaRazglednica = new ArrayList<>();
		for(int i=1; i<=15; i++){
			try{
				listaRazglednica.add( new Razglednica("Primalac"+i, "Posiljalac"+1, random.nextInt(10)+1,"Sadrzaj(BanjaLuka)"+i, "Slika"+i+".png"));
			}catch(Exception ex){
				System.err.println(ex);
			}
		}
		return listaRazglednica;
	}
	
	public static ArrayList<Pismo> generisiListuPisama(){
		ArrayList<Pismo> listaPisama = new ArrayList<>();
		for(int i=1; i<=15; i++){
			listaPisama.add( new Pismo("Primalac"+i, "Posiljalac"+1, random.nextInt(20)+1, "Sadrzaj(BanjaLuka)"+i));
		}
		return listaPisama;
	}
		
	public static ArrayList<VrijednosnaPosiljka> generisiListuVrijednosnihPosiljki(){
		ArrayList<VrijednosnaPosiljka> listaVrijednosnihPosiljki = new ArrayList<>();
		for(int i=1; i<=15; i++){
			listaVrijednosnihPosiljki.add( new VrijednosnaPosiljka("Primalac"+i, "Posiljalac"+i, random.nextInt(100)+1, Valuta.values()[i%3]));
		}
		return listaVrijednosnihPosiljki;
	}
	
	public static void main(String[] args){
		startTime = new Date().getTime();
		
		ArrayList<Posiljka> kolekcijaPosiljki = new ArrayList<>();
		kolekcijaPosiljki.addAll(generisiListuRazglednica());
		kolekcijaPosiljki.addAll(generisiListuPisama());
		kolekcijaPosiljki.addAll(generisiListuVrijednosnihPosiljki());
		
		Collections.shuffle(kolekcijaPosiljki);
		
		RazvrstavanjeNit razvrstavanjeNit = new RazvrstavanjeNit(kolekcijaPosiljki);
		razvrstavanjeNit.start();
		try{
			razvrstavanjeNit.join();
		}catch(InterruptedException ex){
			ex.printStackTrace();
		}
	}
}
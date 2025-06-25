
import java.util.*;
import java.io.*;
import java.nio.file.*;

public class Main{
	
	public static final int X=2;
	public static final int Y=10;
	public static final int Z=10;
	
	public static Object[][][] matrica = new Object[X][Y][Z];
	public static PrintWriter pw;
	
	public static void printaj(Atrakcijica atrakcijica){
		pw.println(atrakcijica);
	}
	
	public static void main(String[] args){
		
		List<Atrakcijica> listaAtrakcija = new ArrayList<>();
		try{
			pw = new PrintWriter(new BufferedWriter(new FileWriter("izlaz.txt")));
		}catch(IOException ex){
			ex.printStackTrace();
		}
		
		for(int i=0; i < 4; i++){
			listaAtrakcija.add(new RolerKoster());
		}
		
		for(int i=0; i < 3; i++){
			listaAtrakcija.add(new Vrteska());
		}
		
		for(int i=0; i < 3; i++){
			listaAtrakcija.add(new TunelVoz());
		}
		
		for(int i=0; i < 2; i++){
			listaAtrakcija.add(new UkletiDvorac());
		}
		
		String line = "start";
		Scanner scanner = new Scanner(System.in);
		
		try{
			do{
			for(var atrakcija:listaAtrakcija){
				atrakcija.start();
			}
			
				line = scanner.nextLine();
			}while(line.equalsIgnoreCase("kraj"));
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		
	}
}
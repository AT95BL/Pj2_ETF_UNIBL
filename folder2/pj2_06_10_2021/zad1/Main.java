import java.util.Scanner;
import java.nio.file.*;
import java.io.*;

public class Main{
	public static boolean running=true;	
	public static final String DRZAVA_PATH="./drzava";
	
	public static void main(String[]args){
		
		Drzava drzava=new Drzava("Republika Srpska");
		
		Scanner scanner=new Scanner(System.in);
		String line;
		
		while(!((line=scanner.nextLine()).equals("END"))){
			
			if(line.contains("REGISTER")){	//	REGISTER folder naziv_univerziteta
				
				try{
					
					var tmp=line.split(" ");
					Path path=Paths.get(tmp[1]);
					Univerzitet univerzitet=new Univerzitet(tmp[2],path);
					drzava.dodajUniverzitet(univerzitet);
					
					UniverzitetWatcher thread=new UniverzitetWatcher(path,univerzitet);
					thread.start();
				}
				catch(IndexOutOfBoundsException e){
					System.out.println("Pogresan format naredbe!!");
				}
			}
			else if(line.contains("STATUS")){
				for(var univerzitet:drzava.univerziteti){
					System.out.println("Univerzitet:"+univerzitet.imeUniverziteta);
					for(var fakultet:univerzitet.fakulteti)	{
						System.out.println("\tFakultet:"+fakultet.imeFakulteta);
						for(var student:fakultet.studenti){
							System.out.println("\t\t"+student);
						}
					}						
				}
			}
			else if(line.contains("ELECTION")){
				Election.startElection(drzava);
				System.out.println("Rezultati izbora(kandidati koji su prosli na drzavnim):");
				Election.pobjedniciNaDrzavnim.forEach(System.out::println);
			}
			else if(line.contains("SAVE")){
				if(!Election.odrzani){
					System.out.println("Izbori nisu odrzani!!");
				}
				else{
					for(var el:Election.kandidatikojiSuProsliFakultetske.entrySet()){
						try	{
							ObjectOutputStream output=new ObjectOutputStream(new FileOutputStream(el.getKey().folderPath.toString()+File.separator+"univerzitet.ser"));
							output.writeObject(el.getValue());
							output.close();
						}
						catch(IOException e){
							System.out.println("Greska na io MAIN!!");
						}
					}
					try{
						ObjectOutputStream output=new ObjectOutputStream(new FileOutputStream(DRZAVA_PATH+File.separator+"drzava.ser"));
						output.writeObject(Election.pobjedniciNaDrzavnim);
						output.close();
					}
					catch(IOException e){
						System.out.println("Greska na io!!");
					}
				}
			}
		}
		running=false;
	}
}
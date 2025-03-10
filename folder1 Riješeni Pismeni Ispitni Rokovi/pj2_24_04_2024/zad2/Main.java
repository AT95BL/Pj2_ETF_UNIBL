
import java.util.*;
import java.io.*;
import java.nio.file.*;

public class Main{
	
	public static void main(String[] args){
		
		if(args.length != 2){
			System.out.println("Greska! Ispravan Format: java Main n root");
			return;
		}
		
		int n=0;
		
		try{
			n = Integer.parseInt(args[0]);
		}catch(NumberFormatException ex){
			ex.printStackTrace();
		}
		
		String line = "";
		Path putanjaPocetnogDirektorijuma = null;
		
		line = args[1];
		putanjaPocetnogDirektorijuma = Paths.get(line);
		
		if(!Files.exists(putanjaPocetnogDirektorijuma)){
			System.out.println("Greska! Root direktorijum ne postoji.");
            return;
		}
		
		//	System.out.println(n + " " + putanjaPocetnogDirektorijuma);	--Provjera validacije učitanih podataka!
		
		// Kreiranje n direktorijuma
		for(int i = 1; i <= n; i++){
			Path noviFolder = putanjaPocetnogDirektorijuma.resolve(String.valueOf(i));
			try{
				Files.createDirectory(noviFolder);
				System.out.println("Direktorijum kreiran: " + noviFolder);
			}catch(Exception ex){
				System.out.println("Greska pri kreiranju direktorijuma: " + noviFolder);
				ex.printStackTrace();
			}
		}
		
		// Pokretanje FileWatcher-a u novoj niti
        try {
            FileWatcher fileWatcher = new FileWatcher(putanjaPocetnogDirektorijuma, n);
            Thread watcherThread = new Thread(fileWatcher);
            watcherThread.start();
        } catch (IOException e) {
            System.out.println("Greska pri pokretanju praćenja fajlova.");
        }
		
		System.out.println("Ukupan broj samoglasnika: " + FileWatcher.UKUPAN_BROJ_SAMOGLASNIKA);
	}
}
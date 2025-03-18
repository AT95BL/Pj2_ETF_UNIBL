
import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.nio.file.*;

public class Main {
	
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("GRESKA! Format: java Main <putanja do pocetnog direktorijuma> <naziv poddirektorijuma>");
            return;
        }

        Path pocetniDirektorijum = Paths.get(args[0]);
        Path putanjaIzlazniDirektorijum = pocetniDirektorijum.resolve(args[1]);
		
		/*
			Kreiranje izlaznih direktorijuma:
		*/
		
        Path putanjaIzlazniDirektorijumTXT = putanjaIzlazniDirektorijum.resolve("txt_files");
        Path putanjaIzlazniDirektorijumPDF = putanjaIzlazniDirektorijum.resolve("pdf_files");
        Path putanjaIzlazniDirektorijumJPG = putanjaIzlazniDirektorijum.resolve("jpg_files");

        try {
            Files.createDirectories(putanjaIzlazniDirektorijumTXT);
            Files.createDirectories(putanjaIzlazniDirektorijumPDF);
            Files.createDirectories(putanjaIzlazniDirektorijumJPG);
        } catch (IOException ex) {
            ex.printStackTrace();
            return;
        }
	
		/*
			Razvrstavanje datoteka po fajlovima:
		*/
		
        try {
            List<Path> svePutanje = Files.walk(pocetniDirektorijum)
                    .filter(Files::isRegularFile)  // Filtriraj samo fajlove, ignoriši foldere
                    .collect(Collectors.toList());

            for (Path putanjaDatoteke : svePutanje) {
                String nazivFajla = putanjaDatoteke.getFileName().toString().toLowerCase();
                Path destinacija = null;

                if (nazivFajla.endsWith(".txt")) {
                    destinacija = putanjaIzlazniDirektorijumTXT;
                } else if (nazivFajla.endsWith(".pdf")) {
                    destinacija = putanjaIzlazniDirektorijumPDF;
                } else if (nazivFajla.endsWith(".jpg")) {
                    destinacija = putanjaIzlazniDirektorijumJPG;
                }

                if (destinacija != null) {
                    Files.copy(putanjaDatoteke, destinacija.resolve(putanjaDatoteke.getFileName()), StandardCopyOption.REPLACE_EXISTING);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
		
		long ukupanBrojTekstualnihDatoteka = 0;
		long ukupnaVelicinaTekstualnihDatoteka = 0; 
		
		long ukupanBrojPDFDatoteka = 0;
		long ukupnaVelicinaPDFDatoteka = 0; 
		
		long ukupanBrojJPGDatoteka = 0;
		long ukupnaVelicinaJPGDatoteka = 0; 
		
		
		try{
			List<Path> svePutanje = Files.walk(putanjaIzlazniDirektorijumTXT)
                    .filter(Files::isRegularFile)  // Filtriraj samo fajlove, ignoriši foldere
                    .collect(Collectors.toList());
			
			for(Path putanja: svePutanje){
				ukupanBrojTekstualnihDatoteka++;
				ukupnaVelicinaTekstualnihDatoteka += Files.size(putanja);
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		try{
			List<Path> svePutanje = Files.walk(putanjaIzlazniDirektorijumPDF)
                    .filter(Files::isRegularFile)  // Filtriraj samo fajlove, ignoriši foldere
                    .collect(Collectors.toList());
			
			for(Path putanja: svePutanje){
				ukupanBrojPDFDatoteka++;
				ukupnaVelicinaPDFDatoteka += Files.size(putanja);
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		try{
			List<Path> svePutanje = Files.walk(putanjaIzlazniDirektorijumJPG)
                    .filter(Files::isRegularFile)  // Filtriraj samo fajlove, ignoriši foldere
                    .collect(Collectors.toList());
			
			for(Path putanja: svePutanje){
				ukupanBrojJPGDatoteka++;
				ukupnaVelicinaJPGDatoteka += Files.size(putanja);
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		double prosjecnaVelicinaTekstualneDatoteke = (ukupanBrojTekstualnihDatoteka > 0) ? 
		(double) ukupnaVelicinaTekstualnihDatoteka / ukupanBrojTekstualnihDatoteka : 0;

		double prosjecnaVelicinaPDFDatoteke = (ukupanBrojPDFDatoteka > 0) ? 
		(double) ukupnaVelicinaPDFDatoteka / ukupanBrojPDFDatoteka : 0;

		double prosjecnaVelicinaJPGDatoteke = (ukupanBrojJPGDatoteka > 0) ? 
		(double) ukupnaVelicinaJPGDatoteka / ukupanBrojJPGDatoteka : 0;

		
		System.out.printf("Ukupan broj tekstualnih datoteka: %d Prosjecna velicina: %.2f bajta%n",
		ukupanBrojTekstualnihDatoteka, prosjecnaVelicinaTekstualneDatoteke);
		System.out.printf("Ukupan broj pdf datoteka: %d Prosjecna velicina: %.2f bajta%n",
		ukupanBrojPDFDatoteka, prosjecnaVelicinaPDFDatoteke);
		System.out.printf("Ukupan broj jpg datoteka: %d Prosjecna velicina: %.2f bajta%n",
		ukupanBrojJPGDatoteka, prosjecnaVelicinaJPGDatoteke);
    }
}

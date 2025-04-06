
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Main{
	public static Map<Character, Character> mapa = new HashMap<>();
	
	public static void postavljanjeSlova(){
		
		// Velika slova
		mapa.put('A', 'А');
		mapa.put('B', 'Б');
		mapa.put('V', 'В');
		mapa.put('G', 'Г');
		mapa.put('D', 'Д');
		mapa.put('Đ', 'Ђ');
		mapa.put('E', 'Е');
		mapa.put('Ž', 'Ж');
		mapa.put('Z', 'З');
		mapa.put('I', 'И');
		mapa.put('J', 'Ј');
		mapa.put('K', 'К');
		mapa.put('L', 'Љ');
		mapa.put('M', 'М');
		mapa.put('N', 'Н');
		mapa.put('O', 'О');
		mapa.put('P', 'П');
		mapa.put('R', 'Р');
		mapa.put('S', 'С');
		mapa.put('T', 'Т');
		mapa.put('Ć', 'Ћ');
		mapa.put('U', 'У');
		mapa.put('F', 'Ф');
		mapa.put('H', 'Х');
		mapa.put('C', 'Ц');
		mapa.put('Č', 'Ч');
		mapa.put('Š', 'Ш');
		mapa.put('W', 'Њ');
		mapa.put('Q', 'Љ');
		mapa.put('X', 'Џ');
		// mapa.put('Y', Ѕ ..
		
		// Mala slova
		mapa.put('a', 'а');
		mapa.put('b', 'б');
		mapa.put('v', 'в');
		mapa.put('g', 'г');
		mapa.put('d', 'д');
		mapa.put('đ', 'ђ');
		mapa.put('e', 'е');
		mapa.put('ž', 'ж');
		mapa.put('z', 'з');
		mapa.put('i', 'и');
		mapa.put('j', 'ј');
		mapa.put('k', 'к');
		mapa.put('l', 'л');
		mapa.put('m', 'м');
		mapa.put('n', 'н');
		mapa.put('o', 'о');
		mapa.put('p', 'п');
		mapa.put('r', 'р');
		mapa.put('s', 'с');
		mapa.put('t', 'т');
		mapa.put('ć', 'ћ');
		mapa.put('u', 'у');
		mapa.put('f', 'ф');
		mapa.put('h', 'х');
		mapa.put('c', 'ц');
		mapa.put('č', 'ч');
		mapa.put('š', 'ш');
		mapa.put('w', 'њ');
		mapa.put('q', 'љ');
		mapa.put('x', 'џ');
	}
	
	public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Greska: Unesite poziciju bar jedne rijeci!");
            return;
        }

        postavljanjeSlova();

        ArrayList<Integer> pozicijeRijeci = new ArrayList<>();
        for (int i = 0; i < args.length; i++) {
            pozicijeRijeci.add(Integer.parseInt(args[i]));
        }
		
		// Napravi RandomAccessFile referencu i objekat..
        try (RandomAccessFile raf = new RandomAccessFile("tekst.txt", "r")) {
			
			// Prolazimo redom kroz sve pohranjene pozicije riječi ..
            for (int i = 0; i < pozicijeRijeci.size(); i++) {
				
                try {
                    if (pozicijeRijeci.get(i) >= raf.length()) {
                        throw new Izuzetak("Pozicija " + pozicijeRijeci.get(i) + " veca od duzine fajla!");
                    }
					
					// POZICIONIRANJE! Sa raf.seek() pozicioniramo se na 'pozicijeRijeci.get(i)' u datoteci koja je prethodno otvorena raf-om..
                    raf.seek(pozicijeRijeci.get(i)); // Sa raf.seek() pozicioniramo se na 'pozicijeRijeci.get(i)' u datoteci koja je prethodno otvorena raf-om..
					
                    char c = (char) raf.read();									//	Sa te pozicije, pročitaj jedan znak..
                    if (!Character.isLetterOrDigit(c)) {													// Ako je taj znakrecimo znak interpunkcije..
                        throw new Izuzetak("Na poziciji " + pozicijeRijeci.get(i) + " se ne nalazi rijec!");
                    } else {
                        StringBuilder latinicnaRijec = new StringBuilder();
                        while (Character.isLetterOrDigit(c)) {												//	Sve dok imaš materijala za čitanje..
                            latinicnaRijec.append(c);
                            c = (char) raf.read();															//	Čitaj redom znak po znak..
                        }

                        StringBuilder cirilicnaRijec = new StringBuilder();
                        for (int j = 0; j < latinicnaRijec.length(); j++) {
                            char pom = latinicnaRijec.charAt(j);
                            cirilicnaRijec.append(mapa.get(pom));
                        }

                        System.out.println("Cirilicna Rijec: " + cirilicnaRijec);
                    }
                } catch (Izuzetak ex) {
                    System.err.println(ex);
                }
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Fajl tekst.txt nije pronadjen: " + ex.getMessage());
        } catch (IOException ex) {
            System.err.println("Greska pri radu sa fajlom: " + ex.getMessage());
        }
    }
}
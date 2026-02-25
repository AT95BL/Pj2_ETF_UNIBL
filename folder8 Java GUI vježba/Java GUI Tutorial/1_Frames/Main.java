import javax.swing.JFrame;		//	https://docs.oracle.com/en/java/javase/17/docs/api/java.desktop/javax/swing/JFrame.html
import javax.swing.ImageIcon;	//	https://docs.oracle.com/en/java/javase/17/docs/api/java.desktop/javax/swing/ImageIcon.html
import java.awt.Color;			//	https://docs.oracle.com/en/java/javase/17/docs/api/java.desktop/java/awt/color/package-summary.html

public class Main
{
	public static void main(String[] args)
	{	
		//	JFrame = a GUI windows to add components to
		
		JFrame frame = new JFrame();	//	creates a frame
		/*
			Prethodna code-line jeste poziv Constructor-a klase JFrame.
			Referenca frame referencira JFrame objekat ili ti jedno (sada malo) platno na koje mozemo da pozicioniramo zeljeni sadrzaj..
			Bukvalno prethodna code-line napravi list(malih dimenzija) blok-papira i ostavlja ga programeru na koristenje..
		*/
		frame.setTitle("JFrame title goes here");	// sets title of frame
		/*
			Kada se tekuci program pokrene, desno od ikonice mozemo vidjeti tekst 	'JFrame title goes here' ,a to je sve proizvod prethodne code-line.
			Inace, pogotovo na Windows-u prozor svakog pokrenutog programa desno od ikonice ima raspisan title..
		*/
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// exit out of application
		/*
			Prethodna code-line jeste instrukcija koja kaze da svaki put kada korisnik programa isti zatvori klikom na X-button
			zatvara se prozor programa ali se gasi/terminira i sam program.
			Bez .EXIT_ON_CLOSE podrazumijeva se HIDE_ON_CLOSE sto ce reci da nakon klika na X dugme prozor se sakriva ali program se ne gasi!!!
			https://docs.oracle.com/en/java/javase/17/docs/api/java.desktop/javax/swing/JFrame.html#setDefaultCloseOperation(int)
		*/
		frame.setResizable(false);	//	prevent frame from being resized
		/*
			Ako iz nekog razloga za nasu GUI aplikaciju zelimo da zabranimo resize GUI APP WINDOW-a 
			taj posao upravo obavljamo prethodnom code-line.
		*/
		
		frame.setSize(420,420);		//	sets the x-dimension, and y-dimension of frame
		/*
			Ako se vratimo na code-line ispod potpisa main metode stoji naglasak na male dimenzije Java Frame prozora.
			Platno-prozor ima sirinu i visinu sto se da predstaviti X i Y koordinatama Dekratovog 3D koordinatnog sistema.
			Svaka tacka duz X/Y ose 0,1,..,419 jeste jedan pixel naseg ekrana..
		*/
		frame.setVisible(true);		//	make frame visible
		/*
			Napominjem da je vidjljivost Java JFrame-a podrazumijevano iskljucena!!!
			Without the frame.setVisible(true); line, the JFrame would not be visible on the screen. 
			By default, when you create a new JFrame object, its visibility property is set to false.
		*/
		
		ImageIcon image = new ImageIcon("C:\\Users\\AT95\\OneDrive\\Desktop\\JavaGUI\\1_frames\\download (8).png");	// create an Image icon
		/*
			Prethodni code-line zahtijeva razumijevanje nekoliko sljedecih stavki:
			1) import javax.swing.ImageIcon;
			2) prethodna code-line jeste Constructor Call i ono sto je ovde interesantno jeste putanja do file(slike)-a i sama slika.
			   Elem, u prilozenom folderu, datoteka imena slika sa esktenzijom .ico je ikonica za jedan program koji sam radio dok sam ucio Python Tkinter.
			   Nimalo naivna ekstenzija .ico zbog koje sam morao sliku u formutu PNG ili JPEG tako nesto da ubacim u GIMP editor koji isto nije naivan
			   te tu sliku da sacuvam sa .ico ekstenzijom kako program ne bi padao i radio onako kako je to i zamisljeno da radi..
			   Za JAVA GUI APP ImageIcon KORISTE SE SLIKE .png EKSTENZIJE!!! (mozda moze i neki drugi ali za projektni ovaj format je siguran)
			3) Source-Code i slika 'download (8).png' se nalaze u istom folderu ali kada se kopira putanja za Windows na svaku / moram dodati jos po jednu // tj.
			   C:\Users\AT95\OneDrive\Desktop\JavaGUI\1_frames ->	C:\\Users\\AT95\\OneDrive\\Desktop\\JavaGUI\\1_frames pa na to sve sam dodao
			   \\download (8).png	i time zavrsio posao..
			Rezultat svega toga jeste to da sada imam referenciran objekat klase ImageIcon koji mogu inicijalizovati za icon svoje Java GUI aplikacije.
			Takodje, promjena ikonice se moze uociti i na samom Windows TaskBar-u.
		*/
		frame.setIconImage(image.getImage());				// change icon of frame	
		/*
			Prethodna code-line inicijalizuje novu ikonicu za moju Java GUI aplikaciju..
		*/
		frame.getContentPane().setBackground(Color.green);	//change color of background
		// frame.getContentPane().setBackground(Color(0, 0, 0));
		// frame.getContentPane().setBackground(Color(255, 0, 0));
		// frame.getContentPane().setBackground(Color(0, 255, 0));
		// frame.getContentPane().setBackground(Color(0, 0, 255));
		// frame.getContentPane().setBackground(Color(255, 255, 255));
		// frame.getContentPane().setBackground(Color(123, 50, 250));
		// frame.getContentPane().setBackground(Color(0XFFFFF));
		/*
			Za kraj tekuceg tutorial-a farbam pozadinu moje Java GUI aplikacije.
			Postoji nekoliko nacina da se to uradi ali bitno je znati sljedece:
			
			1)	import java.awt.Color;
			2) 	RGB nacin farbanja:
			2.1) tekstualnom metodom Color.green
			2.2) Color(0, 0, 0)-crna, Color(255, 255, 255)-bijela pa podesavanjem brojeva pravimo balans izmedju nijansi
			2.3) Color(0xFFFFF) -heksadecimalna notacija, na Google se lako moze vidjeti spisak boja i njihovih heksadecimalnih vrijednosti..
		*/
		
		/*
			MyFrame myFrame = new MyFrame(); 	//		Constructor call
			ili ti da probas samo sa	new MyFrame() 	kad vec neces koristiti objekat te klase..
		*/
	}
}
/*
	Dakle, u ovom tutorial-u naucio sam da radim sa objektima	JFrame && ImageIcon klasa i da koristim Color iz java.awt paketa.
	Za projektni zadatak ovo znanje je vise nego potrebno, a za najbolje razumijevanje navedenih stavki predlazem citaonicu
	da navedeni code prekucava line-by-line te svaki put iznova i iznova kompajlira i pokrece program kako bi isti mogao da vidi promjene koje prate
	svaku code-line.
	
	Standardna procedura za kreiranje prozora:
			this.setTitle("JFrame title goes here");	// sets title of frame
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// exit out of application
			this.setResizable(false);	//	prevent frame from being resized
			this.setSize(420,420);		//	sets the x-dimension, and y-dimension of frame
			this.setVisible(true);		//	make frame visible
*/
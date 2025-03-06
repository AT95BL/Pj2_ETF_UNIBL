import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.Border;	//	https://docs.oracle.com/en/java/javase/17/docs/api/java.desktop/javax/swing/border/Border.html
import javax.swing.BorderFactory;	//	https://docs.oracle.com/en/java/javase/17/docs/api/java.desktop/javax/swing/BorderFactory.html

import java.awt.Color;
import java.awt.Font;				//	https://docs.oracle.com/en/java/javase/17/docs/api/java.desktop/java/awt/Font.html

public class Main
{
	public static void main(String[] args)
	{
		
		//	JLabel = a GUI display area for a string of text, an image, or both
		
		ImageIcon image = new ImageIcon("C:\\Users\\AT95\\OneDrive\\Desktop\\Java GUI Tutorial\\2_labels\\image.jfif");
		Border border = BorderFactory.createLineBorder(Color.red, 3);
		/*
			Border border: This declares a variable named border of type Border. 
			The Border class is used to define the appearance of the border around a UI component.
			BorderFactory.createLineBorder(...): This is a static method from the BorderFactory class, which is a utility class in Swing for creating various types of borders. 
			The method createLineBorder(...) is used to create a simple line border with specific properties.
			Color.red: This is a reference to the Color class's red constant, which represents the color red. 
			In this context, it specifies the color of the border you want to create.
		    This number represents the thickness of the border line in pixels.
			So, when you put it all together, the line of code is creating a red line border with a thickness of 3 pixels and assigning it to the border variable. 
			You can then use this border object to set the border of a Swing component, like a panel or a button, by calling a method like setBorder(border) on that component. 
			This will visually surround the component with a red line border of the specified thickness.
		*/
		
		JLabel label = new JLabel();				//	create a label
		/*
			2. 
			Constructor Call.
			Sada je label referenca za objekat klase JLabel.
			Napominjem to da se klasa JLabel mora import-ovati iz javax.swing paketa!!!
		*/
		label.setText("Bro do you even code?");	//	set text of label 
		/*
			3. 
			Kada se odlucim za pokretanje programa te pokrenem isti na slici(labeli) vidim ispisan ovaj tekst.
			Prethodne 2 code-line se mogu objediniti u <=>	JLabel label = new JLabel("Bro, do you even code?");.
		*/
		label.setIcon(image);
		/*
			4.	
			Labele mogu biti slike, tekstovi,..uglavnom za ovaj tutorial odluceno je da to bude slika koju dostavljam u prilogu.
			Prethodna code-line jeste nista drugo nego obican method call..
		*/
		label.setHorizontalTextPosition(JLabel.CENTER);	//	set text LEFT, CENTER, RIGHT of imageicon
		label.setVerticalTextPosition(JLabel.TOP);		//	set text TOP, CENTER, BOTTOM of imageicon	
		/*
			5.
			Labela( slika + tekst ) i sada hocu da uslikadim.
			Kada se program pokrene vidim da je duz horizontale tekst centriran u odnosu na sliku -CENTER. 
			Kada se program pokrene vidim da je tekst po vertikali iznad slike -TOP.
		
		*/
		label.setForeground(new Color(0, 255, 0));				//	set font color of text
		/*
			6.
			Farbanje teksta raspisanog duz labele..
		*/
		label.setFont(new Font("MV Boli", Font.PLAIN, 20));		//	set font of text
		label.setIconTextGap(50);								//	set gap of text to image
		label.setBackground(Color.black);
		label.setOpaque(true);
		/*
			7.
			Dimenzija prozora tj. JFrame je >> u odnosu na ovdje kreiranu labelu.
			Pozicioniranjem slike i teksta izmedju labele i letvica prozora zijapi bjelina..
			Prethodnom code-line ta bjelina je ofarbana u izbornu crnu boju..
			Da bi promjena bila vidljiva e u tu svrhu sluzi metoda setOpaque();.
		*/
		label.setBorder(border);
		/*
			8.
			Prethodna code-line uokviruje labelu.
		*/
		label.setVerticalAlignment(JLabel.CENTER); 		// set vertical position of icon+text within label
		label.setHorizontalAlignment(JLabel.CENTER);	// set horizontal position of icon+text within label
		label.setBounds(100, 100, 250, 250);	//	set x,y position within frame as well as dimensions
		/*
			9. 
			Linijski komentari sve opisuju.
			Zanimljivo je to kako metodom setBounds();
			labelu horizontalno postavljamo od 100 i ogranicavamo sa 250 pixel-a,
			labelu vertikalno spustamo na dole za 100 tacaka i ogranicavamo sa 250 pixel-a..
		*/
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.add(label);
		/*
			1.	
			Ovaj tutorial ima namjenu korisnika da obuci za rad sa labelama.
			Tako da 1. korak jeste samo postavljenje/ubacivanje labele na platno..
		*/
		
		//frame.pack();	
	}
}

/*
	Rezime:
	
	1.	
	Tutorial ima namjenu da obuci korisnika za rad sa labelama.
	Labela = neki tekst, neka slika, kombinacija slika+tekst i jednostavno u neku ruku to je objekat koji se istice, a najbokej se vidi na web-str.
	Uokvirene podoblasti web-str jesu nista drugo nego labele.
	Labelu ubacujemo u nas radni prostor tako da se objekat klase JLabel dava objektu JFrame na koristenje.
	
	2.
	Da bi realizovali 1. labela se mora napraviti. U Java programskom jeziku vlada OOP tako da Constructor Call klase JLabel 
	da se napravi objekat te klase pa isti refenrenciramo kako bi ga upravo preko te reference i mogli koristiti. 
	(Kao i sa svim drugim i dostupnim objektima razlicitih drugih Java klasa sto built-in sto korisnicki definisanih.
	Dakle, sada u nasem programu imamo objekat klase JFrame sa podesenim njegovim atributima i istom smo dali jednu labelu
	tako da se sve to takvo kakvo je nalazi na platnu...
	
	3. && 4.
	Labela = slika, tekst ili kombinacija slika+tekst pa hajde prvo da ubacimo taj tekst..
	Hajmo sada ubaciti i sliku..
	Dakle, imamo jedan frame i u njemu labelu( sa slikom i tekstom ) pa sada kada smo to odradili trebalo bi malo da se pozabavimo
	farbanje, pozicioniranjem i tako tim front-end stvarima..
	
	5.
	Odredimo poziciju teksta u odnosu na sliku.
	Dakle radi se o smislu podesavanja tekst ispod/iznad slike, tekst lijevo,desno,centar od slike itd..
	
	6.
	Farbanje teksta.
	
	7. &&  8. && 9.
	Sve je vec vise nego dovoljno pojasnjeno u samom komentaru..
	
		Tutorial se prati ovako:
	
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.add(label);
		
		JLabel label = new JLabel();
		label.setText("Bro do you even code?");
		label.setIcon(image);
		label.setHorizontalTextPosition(JLabel.CENTER);	
		label.setVerticalTextPosition(JLabel.TOP);
		label.setForeground(new Color(0, 255, 0));
		label.setFont(new Font("MV Boli", Font.PLAIN, 20));		
		label.setIconTextGap(50);								
		label.setBackground(Color.black);
		label.setOpaque(true);
		label.setBorder(border);
		label.setVerticalAlignment(JLabel.CENTER); 		
		label.setHorizontalAlignment(JLabel.CENTER);	
		label.setBounds(100, 100, 250, 250);
*/
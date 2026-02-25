import java.awt.*;
import javax.swing.*;		//	https://docs.oracle.com/en/java/javase/17/docs/api/java.desktop/javax/swing/JProgressBar.html

public class ProgressBarDemo
{
	JFrame frame = new JFrame();
	JProgressBar bar = new JProgressBar(0,100);
	
	ProgressBarDemo()
	{
		bar.setValue(0);
		bar.setBounds(0,0,420,50);
		/*
			(x=0,y=) znaci da bar pocinje da se proteze duz ekrana pocevsi od gornjeg lijevog ugla aplikacijskog prozora.
			duzina mu je 420 tacaka, a visina 50 tacaka , naravno ne po default-u vec je tako ovdje isprogramirano.
		*/
		bar.setStringPainted(true);
		bar.setFont(new Font("MV Boli", Font.BOLD, 25));
		bar.setForeground(Color.red);
		bar.setBackground(Color.black);
		
		frame.add(bar);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		frame.setLayout(null);
		frame.setVisible(true);
		
		fill();
	}
	
	public void fill()
	{
		int counter = 0;							//	int counter = 500; 
		
		while(counter <= 100)						//	while(counter > 0)
		{
			bar.setValue(counter);
			
			try
			{
				Thread.sleep(50);
			}
			catch(InterruptedException ex)
			{
				ex.printStackTrace();
			}
			counter += 1;							//	counter -= 1;
		}
		
		bar.setString("Done! :)");
	}
}
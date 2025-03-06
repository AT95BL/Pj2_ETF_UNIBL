import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LaunchPage implements ActionListener
{
	JFrame frame = new JFrame();
	JButton myButton = new JButton("New Window");
	
	public LaunchPage()
	{
		myButton.setBounds(100,160,200,40);
		myButton.setFocusable(false);
		myButton.addActionListener(this);
		
		frame.add(myButton);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		frame.setLayout(null);
		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==myButton)
		{
			frame.dispose();
			NewWindow myWindow = new NewWindow();
		}
	}
}
/*
	Sve je vec objasnjeno kroy 4. tutorial ili ti Buttons.
	Ova klasa implementira ActionListener interface, Override actionPerformed metodu koja kao argument ima referencu 'e' na 
	objekat klase ActionEvent i svaki klik na dugme <=> myButton.addActionListener(this);
*/
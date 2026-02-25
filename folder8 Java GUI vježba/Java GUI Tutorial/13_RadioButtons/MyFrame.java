import java.awt.*;
import java.awt.event.*;
import javax.swing.*;			//	https://docs.oracle.com/en/java/javase/17/docs/api/java.desktop/javax/swing/ButtonGroup.html

public class MyFrame extends JFrame implements ActionListener
{
	
	JRadioButton pizzaButton;
	JRadioButton hamburgerButton;
	JRadioButton hotdogButton;
	
	ImageIcon pizzaIcon;
	ImageIcon hamburgerIcon;
	ImageIcon hotdogIcon;
	
	MyFrame()
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		// setting icons and buttons ready
		pizzaIcon = new ImageIcon("C:\\Users\\AT95\\OneDrive\\Desktop\\Java GUI Tutorial\\13_RadioButtons\\pngtree-pizza-vector-illustration-png-image_2155631.jpg");
		hamburgerIcon = new ImageIcon("C:\\Users\\AT95\\OneDrive\\Desktop\\Java GUI Tutorial\\13_RadioButtons\\download.png");
		hotdogIcon = new ImageIcon("C:\\Users\\AT95\\OneDrive\\Desktop\\Java GUI Tutorial\\13_RadioButtons\\images.jfif");
		pizzaButton = new JRadioButton("pizza");
		hamburgerButton = new JRadioButton("hamburger");
		hotdogButton = new JRadioButton("hotdog");
		
		ButtonGroup group = new ButtonGroup();
		/*
			In this line, a new instance of the ButtonGroup class is created and assigned to the variable named group. 
			A ButtonGroup is a container that helps manage a group of radio buttons, ensuring that only one radio button within the group can be selected at a time. 
			When one radio button is selected, any previously selected radio button within the same group will automatically be deselected.
		*/
		group.add(pizzaButton);
		group.add(hamburgerButton);
		group.add(hotdogButton);
		
		// making buttons functional
		pizzaButton.addActionListener(this);
		hamburgerButton.addActionListener(this);
		hotdogButton.addActionListener(this);
		// setting the icons for buttons
		pizzaButton.setIcon(pizzaIcon);
		hamburgerButton.setIcon(hamburgerIcon);
		hotdogButton.setIcon(hotdogIcon);
		
		this.add(pizzaButton);
		this.add(hamburgerButton);
		this.add(hotdogButton);
		this.pack();
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == pizzaButton)
		{
			System.out.println("You ordered pizza!");
		}
		else if(e.getSource() == hamburgerButton)
		{
			System.out.println("You ordered hamburger!");
		}
		else if(e.getSource() == hotdogButton)
		{
			System.out.println("You ordered hotdog!");
		}
	}
}
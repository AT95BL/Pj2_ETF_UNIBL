import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class MyFrame extends JFrame implements KeyListener
{
	JLabel label;
	ImageIcon rocketIcon = new ImageIcon("C:\\Users\\AT95\\OneDrive\\Desktop\\Java GUI Tutorial\\20_KeyListener\\rocket.jpg");
	
	MyFrame()
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,500);
		this.setLayout(null);
		this.addKeyListener(this);
		
		label = new JLabel();
		label.setBounds(0,0,40,64);
		label.setBackground(Color.red);
		label.setOpaque(true);
		
		label.setIcon(rocketIcon);
		
		this.getContentPane().setBackground(Color.black); 
		this.add(label);
		this.setVisible(true);
	}
	
	@Override
	public void keyTyped(KeyEvent e)
	{
		// KeyTyped = Invoked when a key is typed. Uses Keychar, char output
		switch(e.getKeyChar())
		{
			case 'a': 	label.setLocation(label.getX()-1, label.getY());
						break;
			
			case 'd':   label.setLocation(label.getX()+1, label.getY());
						break;
						
			case 'w':   label.setLocation(label.getX(), label.getY()-1);
						break;
						
			case 's':   label.setLocation(label.getX(), label.getY()+1);
						break;
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e)
	{
		// KeyPressed = Invoked when a physical key is pressed down. Uses KeyCode, int output
		switch(e.getKeyCode())
		{
			case 37: 	label.setLocation(label.getX()-1, label.getY());
						break;
			
			case 39:   label.setLocation(label.getX()+1, label.getY());
						break;
						
			case 38:   label.setLocation(label.getX(), label.getY()-1);
						break;
						
			case 40:   label.setLocation(label.getX(), label.getY()+1);
						break;
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e)
	{
		// KeyReleased = called whenever a button is released
		System.out.println("You released key char: " + e.getKeyChar());
		System.out.println("You released key code: " + e.getKeyCode());
	}
}
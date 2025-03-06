import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MyFrame extends JFrame implements MouseListener
{
	JLabel label;
	
	ImageIcon carIcon1 = new ImageIcon("C:\\Users\\AT95\\OneDrive\\Desktop\\Java GUI Tutorial\\21_MouseListener\\51190546.jpg");
	ImageIcon carIcon2 = new ImageIcon("C:\\Users\\AT95\\OneDrive\\Desktop\\Java GUI Tutorial\\21_MouseListener\\images.jfif");
	ImageIcon carIcon3 = new ImageIcon("C:\\Users\\AT95\\OneDrive\\Desktop\\Java GUI Tutorial\\21_MouseListener\\51190546.jpg");
	ImageIcon carIcon4 = new ImageIcon("C:\\Users\\AT95\\OneDrive\\Desktop\\Java GUI Tutorial\\21_MouseListener\\x1080.jfif");
	
	MyFrame()
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1500,1500);
		this.setLayout(null);
		
		label = new JLabel();
		label.setBounds(0,0,500,500);
		label.setBackground(Color.red);
		label.setOpaque(true);
		label.addMouseListener(this);
		
		this.add(label);
		this.setVisible(true);
	}
	
	@Override
	public void mouseClicked(MouseEvent e)
	{
		//	Invoked when the mouse button has been clicked (pressed and released) on a component
		System.out.println("You clicked the mouse");
		label.setIcon(carIcon1);
	}
	
	@Override
	public void mousePressed(MouseEvent e)
	{
		//	Ivoked when a mouse button has been pressed on a component
		System.out.println("You pressed the mouse");
		//label.setBackground(Color.yellow);
		label.setIcon(carIcon2);
	}
	
	@Override
	public void mouseReleased(MouseEvent e)
	{
		//	Invoked when a mouse button has been released on a component
		System.out.println("You released the mouse");
		// label.setBackground(Color.green);
		label.setIcon(carIcon3);
	}
	
	@Override
	public void mouseEntered(MouseEvent e)
	{
		//	Invoked when the mouse enters a component
		System.out.println("You entered the mouse");
		//label.setBackground(Color.blue);
		label.setIcon(carIcon4);
	}
	
	@Override
	public void mouseExited(MouseEvent e)
	{
		//	Invoked when the mouse exits a component
		System.out.println("You exited the mouse");
		label.setBackground(Color.red);
	}
}
import java.awt.FlowLayout;		//	https://docs.oracle.com/en/java/javase/17/docs/api/java.desktop/java/awt/FlowLayout.html
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;		//	https://docs.oracle.com/en/java/javase/17/docs/api/java.desktop/java/awt/Dimension.html

public class Main
{
	public static void main(String[] args)
	{
		//	Layout Manager = Defines the natural layout for components within a container
		
		//	FlowLayout =	 places components in a row, sized at their preferred size.
		//					 If the horizontal space in the container is to small,
		//					 the FlowLayout class uses the next available row.
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		
		JPanel panel = new JPanel();
		//panel.setPreferredSize(new Dimension(250,250));
		panel.setBackground(Color.lightGray);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		
		/*
		frame.add(new JButton("1"));
		frame.add(new JButton("2"));
		frame.add(new JButton("3"));
		frame.add(new JButton("4"));
		frame.add(new JButton("5"));
		frame.add(new JButton("6"));
		frame.add(new JButton("7"));
		frame.add(new JButton("8"));
		frame.add(new JButton("9"));
		*/
		
		panel.add(new JButton("1"));
		panel.add(new JButton("2"));
		panel.add(new JButton("3"));
		panel.add(new JButton("4"));
		panel.add(new JButton("5"));
		panel.add(new JButton("6"));
		panel.add(new JButton("7"));
		panel.add(new JButton("8"));
		panel.add(new JButton("9"));
		
		frame.add(panel);
		frame.setVisible(true);
	}
}
/*
	
*/
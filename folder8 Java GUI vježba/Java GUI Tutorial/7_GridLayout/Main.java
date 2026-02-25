import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JButton;

public class Main
{
	public static void main(String[] args)
	{
		//	Layout Manager = Defines the natural layout for components within a container
		
		//	GridLayout =	 places components in a grid of cells.
		//					 each component takes all the available space within its cell,
		//					 and each cell is the same size.
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setLayout(new GridLayout(3,3,10,10));
		/*
			3 vrste, 3 kolone
			10 sirine horizontalnog razmaka, 10 sirine vertikalnog razmaka
		*/
		
		frame.add(new JButton("1"));
		frame.add(new JButton("2"));
		frame.add(new JButton("3"));
		frame.add(new JButton("4"));
		frame.add(new JButton("5"));
		frame.add(new JButton("6"));
		frame.add(new JButton("7"));
		frame.add(new JButton("8"));
		frame.add(new JButton("9"));
		
		frame.setVisible(true);
	}
}
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.Color;

public class MyFrame extends JFrame
{
			
		public MyFrame()
		{
			this.setTitle("JFrame title goes here");	// sets title of frame
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// exit out of application
			this.setResizable(false);	//	prevent frame from being resized
			this.setSize(420,420);		//	sets the x-dimension, and y-dimension of frame
			this.setVisible(true);		//	make frame visible
			
			ImageIcon image = new ImageIcon("C:\\Users\\AT95\\OneDrive\\Desktop\\JavaGUI\\1_frames\\download (8).png");	// create an Image icon
		
			this.setIconImage(image.getImage());				// change icon of frame	
			this.getContentPane().setBackground(Color.green);
		}
}

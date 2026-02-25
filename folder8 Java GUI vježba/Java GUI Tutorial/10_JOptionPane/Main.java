import javax.swing.JOptionPane;	//	https://docs.oracle.com/en/java/javase/17/docs/api/java.desktop/javax/swing/JOptionPane.html
import javax.swing.ImageIcon;

public class Main
{
	public static void main(String[] args)
	{
		//	JOptionPane = 	pop up a standard dialog box that prompts users for a value 
		//					or informs them of something.
		
		/*
		JOptionPane.showMessageDialog(null, "This is some useless info.", "This is a title", JOptionPane.PLAIN_MESSAGE);
		JOptionPane.showMessageDialog(null, "Here is more useless info..", "This is a title", JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(null, "Is this info useless to you?", "This is a title", JOptionPane.QUESTION_MESSAGE);
		while(true)
		{
			JOptionPane.showMessageDialog(null, "Your Computer Has A Virus!", "This is a title", JOptionPane.WARNING_MESSAGE);
		}
		JOptionPane.showMessageDialog(null, "Call the tech support..NOW OR ELSE!!!", "This is a title", JOptionPane.ERROR_MESSAGE);
		*/
		
		JOptionPane.showConfirmDialog(null, "Bro do you even code?", "This is my title", JOptionPane.YES_NO_CANCEL_OPTION);
		
		String name = JOptionPane.showInputDialog("What is your name?: ");
		System.out.println("Hello " + name);
		
		String[] resposnses = {"No, you are awesome!", "thank you!", "*blush*"};
		ImageIcon icon = new ImageIcon("C:\\Users\\AT95\\OneDrive\\Desktop\\Java GUI Tutorial\\10_JOptionPane\\png-transparent-smiley-thumb-signal-emoticon-smiley-miscellaneous-face-emoji resize1.png");
		JOptionPane.showOptionDialog(
		null, 
		"You are awesome", 
		"secret message", 
		JOptionPane.YES_NO_CANCEL_OPTION, 
		JOptionPane.INFORMATION_MESSAGE, 
		icon, 
		resposnses, 
		0);	
	}
}
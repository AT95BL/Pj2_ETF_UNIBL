import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class MyFrame extends JFrame implements ActionListener
{
	JCheckBox checkBox;
	JButton button;
	ImageIcon xIcon;
	ImageIcon checkIcon;
	
	MyFrame()
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		xIcon = new ImageIcon("C:\\Users\\AT95\\OneDrive\\Desktop\\Java GUI Tutorial\\12_Checkboxes\\x-png-x-drawing-transparent-background-32.png");
		checkIcon = new ImageIcon("C:\\Users\\AT95\\OneDrive\\Desktop\\Java GUI Tutorial\\12_Checkboxes\\images.jfif");
		
		button = new JButton("Submit");
		button.addActionListener(this);
		
	    checkBox = new JCheckBox();
		checkBox.setText("I'm not a robot");
		checkBox.setFocusable(false);
		checkBox.setFont(new Font("Consolas", Font.PLAIN, 35));
		checkBox.setIcon(xIcon);
		checkBox.setSelectedIcon(checkIcon);
		
		this.add(button);
		this.add(checkBox);
		this.pack();
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == button)
		{
			System.out.println(checkBox.isSelected());
		}
	}
}
/*
	checkBox.setIcon(xIcon);
	checkBox.setSelectedIcon(checkIcon);
	
	In this code, you are setting xIcon as the default icon for the checkbox using setIcon, 
	and you are setting checkIcon as the selected icon for the checkbox using setSelectedIcon.
	
	When you click on the checkbox, it becomes "selected" (checked). 
	As a result, the selected icon (checkIcon) is displayed. 
	When you click on it again to unselect it, the default icon (xIcon) is displayed.
	This behavior is inherent to how checkbox icons work in many GUI frameworks.	
	When a checkbox is selected, the selected icon is displayed, and when it is unselected, the default icon is displayed.
	
	If you want to change the icon when the button is clicked, you'll need to modify your code to achieve that. 
	It looks like your current action listener is printing the state of the checkbox (isSelected()), which doesn't directly relate to changing the checkbox icon. 
	If you want the icon to change when the button is clicked, you'll need to update the icon properties within 
	the actionPerformed method based on some condition or logic you define.
*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyFrame extends JFrame implements ActionListener
{
	JMenuBar menuBar = new JMenuBar();							//	https://docs.oracle.com/en/java/javase/17/docs/api/java.desktop/javax/swing/JMenuBar.html
	
	JMenu fileMenu = new JMenu("File");							//  https://docs.oracle.com/en/java/javase/17/docs/api/java.desktop/javax/swing/JMenu.html
	JMenu editMenu = new JMenu("Edit");
	JMenu helpMenu = new JMenu("Help");
	
	JMenuItem loadItem = new JMenuItem("Load");
	JMenuItem saveItem = new JMenuItem("Save");
	JMenuItem exitItem = new JMenuItem("Exit");
	
	ImageIcon loadIcon = new ImageIcon("C:\\Users\\AT95\\OneDrive\\Desktop\\Java GUI Tutorial\\17_MenuBar\\pngtree-load-the-3273350-png-image_1733730.jpg");
	ImageIcon saveIcon = new ImageIcon("C:\\Users\\AT95\\OneDrive\\Desktop\\Java GUI Tutorial\\17_MenuBar\\4136712.png");
	ImageIcon exitIcon = new ImageIcon("C:\\Users\\AT95\\OneDrive\\Desktop\\Java GUI Tutorial\\17_MenuBar\\download.png");
	
	MyFrame()
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,500);
		this.setLayout(new FlowLayout());
		
		loadItem.addActionListener(this);
		saveItem.addActionListener(this);
		exitItem.addActionListener(this);
		
		fileMenu.setMnemonic(KeyEvent.VK_F);
		editMenu.setMnemonic(KeyEvent.VK_E);
		helpMenu.setMnemonic(KeyEvent.VK_H);
		
		loadItem.setMnemonic(KeyEvent.VK_L);
		saveItem.setMnemonic(KeyEvent.VK_S);
		exitItem.setMnemonic(KeyEvent.VK_E);
		
		loadItem.setIcon(loadIcon);
		saveItem.setIcon(saveIcon);
		exitItem.setIcon(exitIcon);
		
		fileMenu.add(loadItem);
		fileMenu.add(saveItem);
		fileMenu.add(exitItem);
		
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(helpMenu);
		
		this.setJMenuBar(menuBar);
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == loadItem)
		{
			System.out.println("You loaded a file..");
		}
		
		else if(e.getSource() == saveItem)
		{
			System.out.println("You saved a file..");
		}
		
		else if(e.getSource() == exitItem)
		{
			System.exit(0);
		}
	}
}
/*
	Komande:
	
		Alt + F:
			S 
			L
			E
		Alt + E
		Alt + H
		
	Probaj..
*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.*;

public class MyPanel extends JPanel implements ActionListener
{
	final int PANEL_WIDTH = 1000;
	final int PANEL_HEIGHT = 1000;
	
	Image enemyImage;
	Image backgroundImage;
	
	Timer timer;
	
	int xVelocity = 1;
	int yVelocity = 1;
	
	int x=0;
	int y=0;
	
	MyPanel()
	{
		this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		this.setBackground(Color.black);
		enemyImage = new ImageIcon("C:\\Users\\AT95\\OneDrive\\Desktop\\Java GUI Tutorial\\25_2D animations\\png-transparent-doomsday-the-death-of-superman-lex-luthor-mongul-superman-comics-heroes-superhero-thumbnail.png").getImage();
		backgroundImage = new ImageIcon("C:\\Users\\AT95\\OneDrive\\Desktop\\Java GUI Tutorial\\25_2D animations\\skyline.jpg").getImage();
		timer = new Timer(10, this);
		timer.start();
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		
		Graphics2D g2D = (Graphics2D) g;
		g2D.drawImage(backgroundImage, 0, 0, null);
		g2D.drawImage(enemyImage, x, y, null);
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(this.x >= PANEL_WIDTH - enemyImage.getWidth(null) || this.x < 0)
		{
			this.xVelocity *= (-1);
		}
		
		this.x = this.x + this.xVelocity;
		
		repaint();
		
		if(this.y >= PANEL_HEIGHT - enemyImage.getHeight(null) || this.y < 0)
		{
			this.yVelocity *= (-1);
		}
		
		this.y = this.y + this.yVelocity;
		
	}
}
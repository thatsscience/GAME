package main;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class Menu extends Component{

	public Rectangle playButton = new Rectangle(GamePanel.WIDTH / 5 + 120, 150,
			100, 50);
	public Rectangle helpButton = new Rectangle(GamePanel.WIDTH / 5 + 120, 250,
			100, 50);
	public Rectangle quitButton = new Rectangle(GamePanel.WIDTH / 5 + 120, 350,
			100, 50);

	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;

		Image img1 = Toolkit.getDefaultToolkit().getImage("start_menu.gif");
	    g2d.drawImage(img1, 0, 0, this);
	    g2d.finalize();
		
		//g.drawImage(img, x, y, observer)
	}
}

package main;

import java.awt.*;
import java.awt.image.*;

import javax.imageio.ImageIO;

import java.io.File;

public class Item {

	private double x;
	private double y;

	private int width;
	private int height;

	private TileMap tileMap;

	private Animation animation;
	private BufferedImage[] coinSprites;

	private boolean remove = false;;
	
	public Item(TileMap tm) {

		tileMap = tm;

		width = 32;
		height = 32;

		try {
			coinSprites = new BufferedImage[8];

			BufferedImage image = ImageIO.read(new File("coin_bounce.png"));
			for (int i = 0; i < coinSprites.length; i++) {
				coinSprites[i] = image.getSubimage(i * width, 0, width, height);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		animation = new Animation();

	}

	
	public double getX() {
		return (int) x;
	}

	public double getY() {
		return (int) y;
	}

	public void setx(int i) {
		x = i;
	}

	public void sety(int i) {
		y = i;
	}

	public void shouldRemove(){
		remove = true;
	}
	// ///////////////////////////////////////////////////////////////////

	public void update() {

		// sprite animation

		animation.setFrames(coinSprites);
		animation.setDelay(100);
		animation.update();
		

	}
	

	public void draw(Graphics2D g) {

		int tx = tileMap.getx();
		int ty = tileMap.gety();
		g.drawImage(animation.getImage(), (int) (tx + x - width / 2), (int) (ty
				+ y - height / 2), null);
		if(remove == true){
			g.drawImage(null, 0, 0, null);
		}
	}
}

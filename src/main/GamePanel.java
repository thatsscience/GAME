package main;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;

public class GamePanel extends JPanel implements Runnable, KeyListener {
	
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	public static int coinCount = 0;
	
	private Thread thread;
	private boolean running;
	
	private BufferedImage image;
	private Graphics2D g;
	
	private int FPS = 30;
	private int targetTime = 1000 / FPS;
	
	private TileMap tileMap;
	private Player player;
	private Item item;
	private boolean intersects = false;
	
	
	
	public GamePanel() {
		super();
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setFocusable(true);
		requestFocus();
	}
	
	public void addNotify() {
		super.addNotify();
		if(thread == null) {
			thread = new Thread(this);
			thread.start();
		}
		addKeyListener(this);
	}
	
	public void run() {
		
		init();
		
		long startTime;
		long urdTime;
		long waitTime;
		
		while(running) {
			
			startTime = System.nanoTime();
			
			update();
			render();
			draw();
			
			urdTime = (System.nanoTime() - startTime) / 1000000;
			waitTime = targetTime - urdTime;
			
			try {
				Thread.sleep(waitTime);
			}
			catch(Exception e) {
			}
			
		}
		
	}
	
	private void init() {
		
		running = true;
		
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		g = (Graphics2D) image.getGraphics();
		
		tileMap = new TileMap("testmap.txt", 32);
		tileMap.loadTiles("tileset.gif");
		
		player = new Player(tileMap);
		player.setx(50);
		player.sety(50);
		
		item = new Item(tileMap);
		item.setx(50);
		item.sety(190);
		
	}
	
	//////////////////////////////////////////////////////////////////////////////
	
	private void update() {
		
		tileMap.update();
		player.update();
		
		item.update();
		
		if((player.getX() + 11 >= item.getX() && player.getX() - 11 <= item.getX())&&(player.getY() + 11 >= item.getY() && player.getY() - 11 <= item.getY())){
			coinCount++;
			System.out.println(coinCount);
			intersects = true;
			
			
		}
//		System.out.printf("PlayerX: %f, PlayerY: %f%n", player.getX(), player.getY() + 10.0);
//		System.out.printf("ItemX: %f, ItemY: %f%n", item.getX(), item.getY());
	}
	
	private void render() {
		
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		tileMap.draw(g);
		player.draw(g);
		
		item.draw(g);
		if(intersects){
			int tempx = (int) item.getX();
			int tempy = (int) item.getY();
			item = new Item(tileMap);
			item.setx(tempx + 50);
			item.sety(tempy + 100);
			
		}
		intersects = false;
		//item.draw(g);
	}
	
	private void draw() {
		Graphics g2 = getGraphics();
		g2.drawImage(image, 0, 0, null);
		g2.dispose();
	}
	
	public void keyTyped(KeyEvent key) {}
	public void keyPressed(KeyEvent key) {
		
		int code = key.getKeyCode();
		
		if(code == KeyEvent.VK_LEFT) {
			player.setLeft(true);
		}
		if(code == KeyEvent.VK_RIGHT) {
			player.setRight(true);
		}
		if(code == KeyEvent.VK_W) {
			player.setJumping(true);
		}
		
	}
	public void keyReleased(KeyEvent key) {
		
		int code = key.getKeyCode();
		
		if(code == KeyEvent.VK_LEFT) {
			player.setLeft(false);
		}
		if(code == KeyEvent.VK_RIGHT) {
			player.setRight(false);
		}
		
	}
	
}
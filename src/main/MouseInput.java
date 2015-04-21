package main;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {

		int mx = e.getX();
		int my = e.getY();
		if (mx >= GamePanel.WIDTH / 4 + 120 && mx <= GamePanel.WIDTH / 4 + 220) {
			if (my >= 150 && my <= 200) {
				// pressed play button
				GamePanel.State = GamePanel.STATE.GAME;
			}
		}
		// quit
		if (mx >= GamePanel.WIDTH / 4 + 120 && mx <= GamePanel.WIDTH / 4 + 220) {
			if (my >= 350 && my <= 400) {
				// pressed play button
				System.exit(1);
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}

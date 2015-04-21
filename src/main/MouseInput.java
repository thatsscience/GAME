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
		if (mx >= 170 && mx <= 330) {
			if (my >= 230 && my <= 265) {
				// pressed play button
				GamePanel.State = GamePanel.STATE.GAME;
			}
		}
		// quit
		if (mx >= 170 && mx <= 330) {
			if (my >= 300 && my <= 340) {
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

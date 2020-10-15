package practice1015;

import java.awt.*;
import java.awt.Graphics;

public class Ball {

	private int x = 100;
	private int y = 100;
	private int size = 30;
	private int xSpeed = 10;
	private int ySpeed = 10;
	
	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillOval(x,  y, size, size);
	}
	
	public void update() {
		x += xSpeed;
		y += ySpeed;
		if((x+size) > BallUpdate_Thread.BOARD_WIDTH - size || x < 0) {
			xSpeed = -xSpeed;
		}
		
		if((y+size) > BallUpdate_Thread.BOARD_HEIGHT - size || y < 0) {
			ySpeed = -ySpeed;
		}
	}
}


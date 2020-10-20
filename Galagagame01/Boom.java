package Galagagame01;

import java.awt.*;

public class Boom extends Sprite{
	private GalagaGame game;
	
	public Boom (GalagaGame game, Image image, int x, int y) {
		super(image, x, y);
		this.game = game;
		dy = -3;
	}
	
	@Override
	public void move() {
		super.move();
		if( y < -100) {
			game.removeSprite(this);
		}
	}
	
	@Override
	public void handleCollision(Sprite other) { // ??? �ּ��ޱ� 
		if(other instanceof AlienSprite) {
			game.removeSprite(this);
			game.removeSprite(other);
		}
	}
}

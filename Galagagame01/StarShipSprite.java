package Galagagame01;
import java.awt.*;

public class StarShipSprite extends Sprite{
	private GalagaGame game; // GalagaGame��ü�� ������ �����ڿ��� �޾�
	
	public StarShipSprite (GalagaGame game, Image image, int x, int y) {
		super(image, x, y);
		this.game = game;
		dx = 0;
		dy = 0;
	}
	
	@Override
	public void move() {
		if((dx < 0) && ( x < 109 )) {
			return;
		}
		if((dx > 0 ) && ( x > 800 )) {
			return;
		}
		super.move();
	}//���ּ��� �����̴� �ڵ�, ��輱�� ������ �� �̻� �������Ѵ�.
	
	@Override
	public void handleCollision(Sprite other) {
		if(other instanceof AlienSprite) {
			game.endGame();
			game.removeSprite(this); //���ּ� �Ҹ�
			game.removeSprite(other); // ���ּ��� ���ϸ��� ���� �Ҹ� 
		}
	}
}


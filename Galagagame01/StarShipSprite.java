package Galagagame01;
import java.awt.*;

public class StarShipSprite extends Sprite{
	private GalagaGame game; // GalagaGame객체의 참조값 생성자에서 받아
	
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
	}//우주선을 움직이는 코드, 경계선에 닿으면 더 이상 못가게한다.
	
	@Override
	public void handleCollision(Sprite other) {
		if(other instanceof AlienSprite) {
			game.endGame();
			game.removeSprite(this); //우주선 소멸
			game.removeSprite(other); // 우주선과 에일리언 같이 소멸 
		}
	}
}


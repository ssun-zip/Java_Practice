package pac201020;

import java.awt.*;

public class Sprite {
	
	protected int x;
	protected int y;
	protected int dx;
	protected int dy;
	protected Image image;
	
	public Sprite(Image image, int x, int y) {
		this.image = image;
		this.x = x;
		this.y = y;
	}
	
	//스프라이트의 가로 길이를 반환한다
	public int getWidth() {
		return image.getWidth(null);
	}
	//스프라이트의 세로 길이를 반환한다
	public int getHeight() {
		return image.getHeight(null);
	}
	
	//스트라이프를 화면에 그린다
	public void draw(Graphics g) {
		g.drawImage(image,  x,  y,  null);
	}
	
	//스트라이트를 움직인데
	public void move() {
		x += dx;
		y += dy;
	}
	
	//dx를 설정한다
	public void setDx(int dx) {
		this.dx = dx;
	}
	
	//dy를 설정한다
	public void setDy(int dy) {
		this.dy = dy;
	}
	
	// dx를 반환한다
	public int getDx() {
		return dx;
	}
	
	// dy를 반환한다
	public int getDy() {
		return dy;
	}
	
	// dx를 반환한다
	public int getX() {
		return x;
	}
	
	// dy를 반환한다
	public int getY() {
		return y;
	}
	
	//스트라이프와 다른 스트라이프와의 충돌 여부를 계산한다. 충돌하면  return true;
	public boolean checkCollision(Sprite other) {
		Rectangle myRect = new Rectangle();
		Rectangle otherRect = new Rectangle();
		myRect.setBounds(x,y, getWidth(), getHeight());
		otherRect.setBounds(other.getX(), other.getY(), other.getWidth(), other.getHeight());
		
		return myRect.intersects(otherRect);
	}
	//충돌을 처리한다
	public void handleCollision(Sprite other) {
		
	}

}

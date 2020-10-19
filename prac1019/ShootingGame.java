package prac1019;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;

import javax.imageio.*;
import javax.swing.*;

class GraphicObject {
	BufferedImage img = null;
	int x = 0, y = 0;
	
	public GraphicObject(String name) {
		try {
			img = ImageIO.read(new File(name));
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
	}
	
	public void update() {
		
	}
	
	//화면에 이미지를 그린다. 
	public void draw(Graphics g) {
		g.drawImage(img,  x, y, null);
	}
	
	public void keyPressed(KeyEvent event) {
		
	}
	
}

//GraphicObject 상속, 미사일을 나타내는 클래스 정의
class Missile extends GraphicObject {
	//boolean launched = false;
	
	public Missile(String name) {
		super(name);
		this.x = 2000;
		this.y = 2000;
	}
	
	public void update() {
		//미사일 위치 변경 
		//if(launched) {
			y -= 10;
		//}
		/*
		if( y < -1000000) {
			launched = false;
		}
		*/
	}
	//스페이스 키가 눌리면 미사일 발사
	public void keyPressed(KeyEvent event, int x, int y) {
		if(event.getKeyCode() == KeyEvent.VK_SPACE) {
			//launched = true;
			this.x = x + 25;
			this.y = y; 
		}
	}


}
//Graphic Object 상속, enemy class
class Enemy extends GraphicObject{
	boolean alive = true;
	int dx = -10;
	public Enemy(String name) {
		super(name);
		x = 500;
		y = 0;
	}
	
	//enemy의 위치변경 
	public void update() {
		//살아있을때만 움직임
		if(alive) {
			x += dx;
			if( x < 0) dx = +10;
		}
		
		if(x > 500) {
			dx = -10;
		}
		
	}
	
}

//spaceship class
class Spaceship extends GraphicObject{
	public Spaceship(String name) {
		super(name);
		x = 150;
		y = 350;
	}
	
	//화사표의 키에 따라 플레이어의 캐릭터 위치 변경
	public void keyPressed(KeyEvent event) {
		if(event.getKeyCode() == KeyEvent.VK_LEFT) {
			x -= 10;
		} else if(event.getKeyCode() == KeyEvent.VK_RIGHT) {
			x += 10;
		} else if(event.getKeyCode() == KeyEvent.VK_UP) {
			y -= 10;
		}else if(event.getKeyCode() == KeyEvent.VK_DOWN) {
			y += 10;
		}
	}
}

class Background extends GraphicObject {
	public Background(String name) {
		super(name);
		x = 0;
		y = 0;
	}
}

class MyPanel extends JPanel implements KeyListener {
	Enemy enemy;
	Spaceship spaceship;
	Missile missile;
	Background background;
	
	public MyPanel() {
		super();
		this.addKeyListener(this);
		this.requestFocus();
		setFocusable(true);
		
		enemy = new Enemy("enemy.png");
		spaceship = new Spaceship("spaceship.png");
		missile= new Missile("missile.png");
		//white background 
		background = new Background("background.png");
		
		//스레드를 이용하여 게임의 메인 루프를 작성
		//각각제의 위치를 변경하고 다시 그린다. 
		class MyThread extends Thread{
			public void run() {
				while(true) {
					enemy.update();
					spaceship.update();
					missile.update();
					//고정이라 생략 가능
					background.update();
					repaint();
					try {
						Thread.sleep(50);;
					} catch (InterruptedException e) {
						
					}
					
					if(Math.sqrt((double)(missile.x - enemy.x)) < 10 &&
					Math.sqrt((double) (missile.y - enemy.y)) < 10){
						try {
							enemy.img = ImageIO.read(new File("bomb.png"));
							System.out.println("적이 죽음");
						} catch (IOException e) {
							e.printStackTrace();
						}
						enemy.alive = false;
					}
				}
			}
		}
		Thread t = new MyThread();
		t.start();
	}
	public void paint(Graphics g) {
		super.paint(g);
		background.draw(g);
		enemy.draw(g);
		spaceship.draw(g);
		missile.draw(g);
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
	}
	@Override
	public void keyPressed(KeyEvent e) {
		spaceship.keyPressed(e);
		missile.keyPressed(e, spaceship.x, spaceship.y);
	}
	@Override
	public void keyReleased(KeyEvent e) {
	}

}
public class ShootingGame extends JFrame{
	
	public ShootingGame() {
		setTitle("Shooting Game");
		add(new MyPanel());
		setSize(500,500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ShootingGame();
	}

}

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
	
	//ȭ�鿡 �̹����� �׸���. 
	public void draw(Graphics g) {
		g.drawImage(img,  x, y, null);
	}
	
	public void keyPressed(KeyEvent event) {
		
	}
	
}

//GraphicObject ���, �̻����� ��Ÿ���� Ŭ���� ����
class Missile extends GraphicObject {
	//boolean launched = false;
	
	public Missile(String name) {
		super(name);
		this.x = 2000;
		this.y = 2000;
	}
	
	public void update() {
		//�̻��� ��ġ ���� 
		//if(launched) {
			y -= 10;
		//}
		/*
		if( y < -1000000) {
			launched = false;
		}
		*/
	}
	//�����̽� Ű�� ������ �̻��� �߻�
	public void keyPressed(KeyEvent event, int x, int y) {
		if(event.getKeyCode() == KeyEvent.VK_SPACE) {
			//launched = true;
			this.x = x + 25;
			this.y = y; 
		}
	}


}
//Graphic Object ���, enemy class
class Enemy extends GraphicObject{
	boolean alive = true;
	int dx = -10;
	public Enemy(String name) {
		super(name);
		x = 500;
		y = 0;
	}
	
	//enemy�� ��ġ���� 
	public void update() {
		//����������� ������
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
	
	//ȭ��ǥ�� Ű�� ���� �÷��̾��� ĳ���� ��ġ ����
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
		
		//�����带 �̿��Ͽ� ������ ���� ������ �ۼ�
		//�������� ��ġ�� �����ϰ� �ٽ� �׸���. 
		class MyThread extends Thread{
			public void run() {
				while(true) {
					enemy.update();
					spaceship.update();
					missile.update();
					//�����̶� ���� ����
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
							System.out.println("���� ����");
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

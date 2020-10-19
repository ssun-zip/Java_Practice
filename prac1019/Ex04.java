package prac1019;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.*;
import java.io.*;

import javax.imageio.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
// Shooting Game 
// missile�� �ӵ��� �� ���� ��s
class GraphicObject03{
	BufferedImage img = null;
	int x = 0, y  = 0;
	
	public GraphicObject03(String name) {
		try {
			img = ImageIO.read(new File(name));
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
	}
	
	public void update() {
		
	}
	
	//����ؼ� ȭ���� ������Ʈ�Ѵ�
	//ȭ�鿡 �̹����� �׸���. 
	public void draw(Graphics g) {
		g.drawImage(img,  x, y, null);
		//�̹����� ����� img�� x, y���� ����Ѵ�
		//Thread�� �ƴ϶� JPanel�� �����Ǳ⿡ null���� ���� 
	}
	
	/*
	public void keyPressed(KeyEvent event) {
		
	}
	*/
	
}

// �̻����� ��Ÿ���� Ŭ������ ����
class Fire extends GraphicObject03{
	boolean fire;
	//fire true or false�� ��Ÿ���� ����
	//Ȥ�� int fire �� ������ ������ �����
	// 65�� ���� ������ true�� �ٲ۵� 73������ ����� �߻簡�ȴ�
	public Fire(String name) {
		super(name); //fire ������, super�� ����
		y = -2;
	}
	
	public void update() {
		if(fire) {
			y -= 50;
			//�̻����� �ӵ��� �ø���
		}
		if(true) {
			//y���� -1���� ������ or �׳� true
			fire = true;
			//Ű���ٰ� �ԷµǸ� fire�� ���� true�� �߻簡 �ȴ�
		}
	}
	
	public void keyPressed(KeyEvent event, int x, int y) {
		if(event.getKeyCode() == KeyEvent.VK_SPACE) {
			//launched = true;
			this.x = x;
			this.y = y; 
			//���ּ��� ��ġ�� �̻����� ��ġ�� �������ش�.
		}
	}
}

class Enemys extends GraphicObject03 {
	boolean alive = true;
	int dx = -10; // ���������� dx�� ����� �ʱⰪ -10 ���� 
	public Enemys(String name) {
		super(name);
		x = 500;
		y = 0;
		//enemy�� ������ġ
	}
	
	//enemy�� ��ġ���� 
	public void update() {
		//����������� ������
		// ������ ����� true���� ���� �� �浹������ false���餷��
		//��ġ�� ���߰� �Ѵ�.
		if(alive) {
			x += dx;
			if( x < 0) dx = +10;
			// ���� x�� 0���� ������ +10�� �ؼ� 0���� ���������� ���Ѵ�
			//�ӵ�
		}
		
		if(x > 500) {
			dx = -10;
		}
		
	}
}

//spaceship class
class Spaceships extends GraphicObject{
	public Spaceships(String name) {
		super(name);
		//spaceship�� ���� ��ġ
		x = 150;
		y = 350;
	}
	
	//ȭ��ǥ�� Ű�� ���� �÷��̾��� ĳ���� ��ġ ����
	public void keyPressed(KeyEvent event) {
		/*
		 * ���� �Է¹��� Ű�� <- �̶�� x���� -10�� �Ѵ�. 
		 * spaceship�� ��ġ�� �������� ����
		 * 
		 * ���� �Է¹��� Ű�� -> �̶�� x���� +10�� �Ѵ�. 
		 * spaceship�� ��ġ�� �������� ����
		 * 
		 * ���� �Է¹��� Ű�� up �̶�� y���� +10�� �Ѵ�. 
		 * spaceship�� ��ġ�� �������� ����
		 * 
		 * ���� �Է¹��� Ű�� down �̶�� y���� -10�� �Ѵ�. 
		 * spaceship�� ��ġ�� �������� ����
		 * 
		 */
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

class MyPanels extends JPanel implements KeyListener {
	Enemys enemy;
	Spaceships spaceship;
	Fire fire;
	Background background;
	
	public MyPanels() {
		super();
		//Ű�� �Է¹ޱ� ����
		this.addKeyListener(this);
		this.requestFocus();
		setFocusable(true);
		//�Է��� ���⼭ �޴´ٴ� ��
		//�Է��� �������� �Է½����尡 �� Ŭ�������� �����ؾ��ϴ� ����
		//��Ŀ���� ���� 
		
		enemy = new Enemys("enemy.png");
		spaceship = new Spaceships("spaceship.png");
		fire = new Fire("missile.png");
		//white background 
		background = new Background("background.png");
		
		//�����带 �̿��Ͽ� ������ ���� ������ �ۼ�
		//�������� ��ġ�� �����ϰ� �ٽ� �׸���. 
		class MyThread extends Thread{
			public void run() {
				while(true) {
					enemy.update();
					spaceship.update();
					fire.update();
					//�����̶� ���� ����
					background.update();
					repaint();
					try {
						Thread.sleep(50);;
					} catch (InterruptedException e) {
						
					}
					
					if(Math.sqrt((double)(fire.x - enemy.x)) < 10 &&
					Math.sqrt((double) (fire.y - enemy.y)) < 10){
						try {
							enemy.img = ImageIO.read(new File("bomb.png"));
							//System.out.println("���� ����");
						} catch (IOException e) {
							e.printStackTrace();
						}
						enemy.alive = false;
						/*
						 * enemy.dx = 0;
						 * if(enemy.dx == 0) enemy.x = fire.x;
						 */
					}
				}
			}
		}
		//����
		Thread t = new MyThread();
		//����
		t.start();
	}
	public void paint(Graphics g) {
		super.paint(g);
		background.draw(g);
		enemy.draw(g);
		spaceship.draw(g);
		fire.draw(g);
		
	}
	//Ű���� �̺�Ʈ �� ��ü ����
	@Override
	public void keyTyped(KeyEvent e) {
	}
	@Override
	public void keyPressed(KeyEvent e) {
		spaceship.keyPressed(e);
		fire.keyPressed(e, spaceship.x, spaceship.y);
	}
	@Override
	public void keyReleased(KeyEvent e) {
	}

}

public class Ex04 extends JFrame{
	public Ex04() {
		setTitle("Shooting Game");
		add(new MyPanels());
		setSize(500,500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Ex04();
	}

}

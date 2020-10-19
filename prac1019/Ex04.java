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
// missile의 속도가 더 빠른 버s
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
	
	//계속해서 화면을 업데이트한다
	//화면에 이미지를 그린다. 
	public void draw(Graphics g) {
		g.drawImage(img,  x, y, null);
		//이미지가 담겨진 img를 x, y값에 출력한다
		//Thread가 아니라 JPanel로 지정되기에 null값이 지정 
	}
	
	/*
	public void keyPressed(KeyEvent event) {
		
	}
	*/
	
}

// 미사일을 나타내는 클래스의 정의
class Fire extends GraphicObject03{
	boolean fire;
	//fire true or false로 나타내기 위해
	//혹은 int fire 로 정수형 변수를 만든뒤
	// 65번 행의 조건을 true로 바꾼뒤 73번행을 비워도 발사가된다
	public Fire(String name) {
		super(name); //fire 생성자, super로 실행
		y = -2;
	}
	
	public void update() {
		if(fire) {
			y -= 50;
			//미사일의 속도를 올린다
		}
		if(true) {
			//y값이 -1보다 작을때 or 그냥 true
			fire = true;
			//키보다가 입력되면 fire의 값이 true로 발사가 된다
		}
	}
	
	public void keyPressed(KeyEvent event, int x, int y) {
		if(event.getKeyCode() == KeyEvent.VK_SPACE) {
			//launched = true;
			this.x = x;
			this.y = y; 
			//우주선의 위치에 미사일을 위치를 지정해준다.
		}
	}
}

class Enemys extends GraphicObject03 {
	boolean alive = true;
	int dx = -10; // 정수형변수 dx를 만든뒤 초기값 -10 대입 
	public Enemys(String name) {
		super(name);
		x = 500;
		y = 0;
		//enemy의 시작위치
	}
	
	//enemy의 위치변경 
	public void update() {
		//살아있을때만 움직임
		// 변수를 만들고 true값을 해준 뒤 충돌했을때 false만들ㅇ더
		//위치가 멈추게 한다.
		if(alive) {
			x += dx;
			if( x < 0) dx = +10;
			// 조건 x가 0보다 작을때 +10을 해서 0보다 꺼질때까지 더한다
			//속도
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
		//spaceship의 시작 위치
		x = 150;
		y = 350;
	}
	
	//화사표의 키에 따라 플레이어의 캐릭터 위치 변경
	public void keyPressed(KeyEvent event) {
		/*
		 * 만약 입력받은 키가 <- 이라면 x값을 -10을 한다. 
		 * spaceship의 위치가 왼쪽으로 간다
		 * 
		 * 만약 입력받은 키가 -> 이라면 x값을 +10을 한다. 
		 * spaceship의 위치가 왼쪽으로 간다
		 * 
		 * 만약 입력받은 키가 up 이라면 y값을 +10을 한다. 
		 * spaceship의 위치가 왼쪽으로 간다
		 * 
		 * 만약 입력받은 키가 down 이라면 y값을 -10을 한다. 
		 * spaceship의 위치가 왼쪽으로 간다
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
		//키를 입력받기 위해
		this.addKeyListener(this);
		this.requestFocus();
		setFocusable(true);
		//입력을 여기서 받는다는 뜻
		//입력을 받으려면 입력스레드가 그 클래스에서 동작해야하는 것을
		//포커스가 해줌 
		
		enemy = new Enemys("enemy.png");
		spaceship = new Spaceships("spaceship.png");
		fire = new Fire("missile.png");
		//white background 
		background = new Background("background.png");
		
		//스레드를 이용하여 게임의 메인 루프를 작성
		//각각제의 위치를 변경하고 다시 그린다. 
		class MyThread extends Thread{
			public void run() {
				while(true) {
					enemy.update();
					spaceship.update();
					fire.update();
					//고정이라 생략 가능
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
							//System.out.println("적이 죽음");
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
		//생성
		Thread t = new MyThread();
		//시작
		t.start();
	}
	public void paint(Graphics g) {
		super.paint(g);
		background.draw(g);
		enemy.draw(g);
		spaceship.draw(g);
		fire.draw(g);
		
	}
	//키보드 이벤트 각 객체 전달
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

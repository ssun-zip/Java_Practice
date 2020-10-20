package pac201020;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;


public class SnakeGameFram extends JFrame {
	Thread snakeThread;
	GroundPanel p;
	public SnakeGameFram() {
		super("스네이크 움직이기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		p = new GroundPanel();
		setContentPane(p);
		//팬널의 사이즈 세팅 
		setSize(400,400);
		setVisible(true);
		p.requestFocus();
		// 스네이크의 스레드 생성 
		snakeThread = new Thread(p);
		// 스레드 시작 
		snakeThread.start();
	}

	class GroundPanel extends JPanel implements Runnable{
		static final int LEFT = 0;
		static final int RIGHT = 1;
		static final int UP = 2;
		static final int DOWN = 3;
		int direction;
		Image img;
		SnakeBody snakeBody;
		final int delay = 200;
		public GroundPanel() {
			setLayout(null);
			snakeBody = new SnakeBody();
			snakeBody.addIn(this);
			// default 방향 왼쪽으로 향하도록 설정
			direction = LEFT;
			this.addKeyListener(new MyKeyListener());
			// 배경 설정 
			ImageIcon icon = new ImageIcon("background01.png");
			img = icon.getImage();
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, 0,0,getWidth(), getHeight(), null);
		}
		public void run() {
			while(true) {
				try {
					// 뱀의 몸이 주어진 방향으로 0.2초 동안 딜레이되어 
					// 지난가는처럼 보이도록 설정
					// 시간차를 두고 진행시켜 마치 뱀이 왼쪽으로 스르륵
					// 움직이는것 같은 효과를 줌 
					Thread.sleep(delay);				
					snakeBody.move(direction);
				}catch(InterruptedException e) {
					return;
				}
			}
		}
				
		class MyKeyListener extends KeyAdapter {
			public void keyPressed(KeyEvent e) {
				// 방향키로 뱀이 향하는 방향을 바꿀수있따. 
				switch(e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					direction = LEFT;
					break;
				case KeyEvent.VK_RIGHT:
					direction = RIGHT;
					break;
				case KeyEvent.VK_UP:
					direction = UP;
					break;
				case KeyEvent.VK_DOWN:
					direction = DOWN;
					break;
				}
			}
		}
	}
	
	class SnakeBody {
		Vector<JLabel> v = new Vector<JLabel>();
		
		public SnakeBody() {
			// 머리 이미지 
			ImageIcon head = new ImageIcon("snkae.png");
			JLabel la = new JLabel(head);
			// 사진의 사이즈 설정 
			la.setSize(head.getIconWidth(), head.getIconHeight());
			// 머리 위치 세팅 
			la.setLocation(100, 100);
			v.add(la);
			
			// 따라가는 몸통 이미지 세팅 
			ImageIcon body = new ImageIcon("snkae.png");		
			for(int i=1; i<10; i++) {
				la = new JLabel(body);
				la.setSize(body.getIconWidth(), body.getIconHeight());
				// 머리의 위치보다 20 더 멀게 세팅 
				la.setLocation(100+i*20, 100);
				v.add(la);
			}
		}
		
		public void addIn(JPanel p) {
			for(int i=0; i<v.size(); i++)
				p.add(v.get(i));
		}
		
		public void move(int direction) {
			for(int i=v.size()-1; i>0; i--) {
				JLabel b = v.get(i);
				JLabel a = v.get(i-1);
				b.setLocation(a.getX(), a.getY());
			}
			JLabel head = v.get(0);
			switch(direction) {
			case GroundPanel.LEFT :
				// 왼쪽으로 움직일때 머리가 20씩 왼쪽으로 움직인다. 
				head.setLocation(head.getX()-20, head.getY());
				break;
			case GroundPanel.RIGHT :
				// 오른쪽으로 움직일때 머리가 20씩 오른쪽으로 움직인다. 
				head.setLocation(head.getX()+20, head.getY());
				break;
			case GroundPanel.UP :
				// 위로 움직일때 머리가 20씩 위로 움직인다. 
				head.setLocation(head.getX(), head.getY()-20);
				break;
			case GroundPanel.DOWN :
				// 아래로 움직일때 머리가 20씩 아래로 움직인다. 
				head.setLocation(head.getX(), head.getY()+20);
				break;
			}
		} 
	}

	public static void main(String[] args) {
		new SnakeGameFram();
	}
}


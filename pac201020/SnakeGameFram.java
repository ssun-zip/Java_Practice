package pac201020;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;


public class SnakeGameFram extends JFrame {
	Thread snakeThread;
	GroundPanel p;
	public SnakeGameFram() {
		super("������ũ �����̱�");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		p = new GroundPanel();
		setContentPane(p);
		//�ҳ��� ������ ���� 
		setSize(400,400);
		setVisible(true);
		p.requestFocus();
		// ������ũ�� ������ ���� 
		snakeThread = new Thread(p);
		// ������ ���� 
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
			// default ���� �������� ���ϵ��� ����
			direction = LEFT;
			this.addKeyListener(new MyKeyListener());
			// ��� ���� 
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
					// ���� ���� �־��� �������� 0.2�� ���� �����̵Ǿ� 
					// ��������ó�� ���̵��� ����
					// �ð����� �ΰ� ������� ��ġ ���� �������� ������
					// �����̴°� ���� ȿ���� �� 
					Thread.sleep(delay);				
					snakeBody.move(direction);
				}catch(InterruptedException e) {
					return;
				}
			}
		}
				
		class MyKeyListener extends KeyAdapter {
			public void keyPressed(KeyEvent e) {
				// ����Ű�� ���� ���ϴ� ������ �ٲܼ��ֵ�. 
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
			// �Ӹ� �̹��� 
			ImageIcon head = new ImageIcon("snkae.png");
			JLabel la = new JLabel(head);
			// ������ ������ ���� 
			la.setSize(head.getIconWidth(), head.getIconHeight());
			// �Ӹ� ��ġ ���� 
			la.setLocation(100, 100);
			v.add(la);
			
			// ���󰡴� ���� �̹��� ���� 
			ImageIcon body = new ImageIcon("snkae.png");		
			for(int i=1; i<10; i++) {
				la = new JLabel(body);
				la.setSize(body.getIconWidth(), body.getIconHeight());
				// �Ӹ��� ��ġ���� 20 �� �ְ� ���� 
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
				// �������� �����϶� �Ӹ��� 20�� �������� �����δ�. 
				head.setLocation(head.getX()-20, head.getY());
				break;
			case GroundPanel.RIGHT :
				// ���������� �����϶� �Ӹ��� 20�� ���������� �����δ�. 
				head.setLocation(head.getX()+20, head.getY());
				break;
			case GroundPanel.UP :
				// ���� �����϶� �Ӹ��� 20�� ���� �����δ�. 
				head.setLocation(head.getX(), head.getY()-20);
				break;
			case GroundPanel.DOWN :
				// �Ʒ��� �����϶� �Ӹ��� 20�� �Ʒ��� �����δ�. 
				head.setLocation(head.getX(), head.getY()+20);
				break;
			}
		} 
	}

	public static void main(String[] args) {
		new SnakeGameFram();
	}
}


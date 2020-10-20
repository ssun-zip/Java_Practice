package pac201020;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;

public class SnowFrame extends JFrame {
	public SnowFrame(){
		super("�� ������ ������ ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setContentPane(new SnowPanel());
		setSize(300,300);
		setResizable(false);
		setVisible(true);
	}
	
	class SnowPanel extends JPanel {
		ImageIcon icon = new ImageIcon("background02.png");
		Image img = icon.getImage();
		final int SNOWS = 50;
		final int SNOW_SIZE = 10;
		Vector<Point> snowVector = new Vector<Point>(); // �� ������ ���� ��ǥ Point
		
		public SnowPanel() {
			this.addComponentListener(new ComponentAdapter() {
				@Override
				public void componentResized(ComponentEvent e) { 
					// �г��� ��ġ�� ũ�Ⱑ �����Ǹ� �� �� ��μ� ���� �����.
					addSnow(); //���� �����
					new SnowThread().start(); // �� ������ �����带 ���۽�Ų��.
					SnowPanel.this.removeComponentListener(this); // ���� �гο� �����ϵ��� ���� ����� �����ʸ� �����Ѵ�.
				}				
			});
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this); // ��� �̹����� �׸���.
			drawSnow(g); // ���� �׸���.
		}
		
		void addSnow() { // �� ���� ��ġ�� �����ϰ� �����Ͽ� ���Ϳ� �����Ѵ�.
			for(int i=0; i<SNOWS; i++) {
				Point p = new Point((int)(Math.random()*getWidth()), 
						(int)(Math.random()*getHeight()));
				snowVector.add(p);
			}
		}
		void drawSnow(Graphics g) { // �гο� ���� �׸���.
			g.setColor(Color.WHITE);			
			for(int i=0; i<snowVector.size(); i++) {
				Point p = snowVector.get(i);
				g.fillOval(p.x, p.y, SNOW_SIZE, SNOW_SIZE);			
			}
		}
		
		void changeSnowPosition() { // ���� ��ġ�� �����Ѵ�. 
			for(int i=0; i<SNOWS; i++) {
				Point p = snowVector.get(i);
				int xDir = Math.random() > 0.5 ? 1 : -1; // xDir�� 1�̸� ����������, �ƴϸ� �������� ���� �̵���Ų��.
				int offsetX = (int)(Math.random()*3)*xDir; // x ������ �̵��ϴ� �ִ� �Ÿ��� 3 �ȼ��̴�.
				int offsetY = (int)(Math.random()*7); // y ������ �̵��ϴ� �ִ� �Ÿ��� 7 �ȼ��̴�.
				p.x += offsetX;
				if(p.x < 0) p.x = 0;
				p.y += offsetY;
				if(p.y > getHeight()) { // ���� �������� �г��� ����� �Ǹ� �ٽ� �г��� ������ �����ϰ� �Ѵ�.
					p.x = (int)(Math.random()*getWidth());  // �ٽ� �����ϴ� x ��ġ�� �г� ���� ������ ��ġ
					p.y = 5; // �ٽ� �����ϴ� y ��ġ�� �г� ���� 5 �ȼ� ��ġ
				}
			}		
		}
		class SnowThread extends Thread {
			public void run() {
				while(true) {
					try {
						sleep(300); // 0.3�ʸ��� ���� ������.
					} catch (InterruptedException e) { return; }
					changeSnowPosition(); // ���� ��ġ�� �������Ѵ�.
					repaint(); // ������ ��ġ�� ���� �׷������� �г��� �ٽ� �׸���.
				}
			}
		}
	}
	
	static public void main(String[] args) {
		new SnowFrame();
	}
}


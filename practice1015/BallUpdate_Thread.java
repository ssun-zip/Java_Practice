package practice1015;

import java.awt.*;

import javax.swing.*;

public class BallUpdate_Thread extends JPanel{
	static final int BOARD_WIDTH = 600;
	static final int BOARD_HEIGHT = 300;
	private Ball ball = new Ball();
	
	public BallUpdate_Thread() {
		this.setBackground(Color.YELLOW);
		Runnable task = () -> {
			while(true) {
				ball.update();
				// update 프로그래머가 repaint를 호풀하면 JVM은 paint를 호출하기 앞서
				// update메소드를 호출한다
				repaint();
				//paint: 프로그래머가 직접 홏풀할수없는 메소드
				//repaint: 프로그래머가 호출할수있는 메소드
				try {
					Thread.sleep(50);
				} catch (InterruptedException ignore) {
				
				}
			}
		};
		
		new Thread(task).start();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		ball.draw(g);
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(BallUpdate_Thread.BOARD_WIDTH, BallUpdate_Thread.BOARD_HEIGHT);;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(new BallUpdate_Thread());
	}

}



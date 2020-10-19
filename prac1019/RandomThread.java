package prac1019;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

class RandomThread01 extends Thread{
	private Container contentPane;
	private boolean flag=false; // 스레드의 종료 명령을 표시하는 플래그 , true:종료지시
	
	public RandomThread01(Container contentPane) {
		this.contentPane = contentPane;
	}
	
	public void finish() {
		flag = true;
	}
	
	@Override
	public void run() {
		while(true) {
			int x = ((int) (Math.random()*contentPane.getWidth()));
			int y = ((int) (Math.random()*contentPane.getHeight()));
			JLabel label = new JLabel ("java");
			label.setSize(80, 30);;
			//레이블을 컨텐트팬 내의 임의의 위치로 설정
			label.setLocation(x, y);
			//레이블을 컨텐트팬에 추가
			contentPane.add(label);
			//컨텐트팬을 다시 그려 추가된 레이블이 보이게 함 
			contentPane.repaint();
			
			try {
				//0.3초 동안 잠들게 한다 
				Thread.sleep(300);
				if(flag == true) {
					contentPane.removeAll();
					label = new JLabel("finish");
					label.setSize(80,30);;
					label.setLocation(100,100);;
					label.setForeground(Color.RED);
					contentPane.add(label);
					contentPane.getIgnoreRepaint();
					return;
				}
			} catch (InterruptedException e ) {
				return;
			}
		}
	}
}
	
	public class RandomThread extends JFrame{
		private RandomThread01 th;
		
		public RandomThread() {
			setTitle("ThreadFinishFlagEx");
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			Container c = getContentPane();
			c.setLayout(null);
			c.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					th.finish();
					//RandomThread 종료 명령
				}
			});
			setSize(300,200);
			setVisible(true);
			th = new RandomThread01(c);
			th.start();
		}
		public static void main(String[] args) {
			new RandomThread();
		}

	}
	
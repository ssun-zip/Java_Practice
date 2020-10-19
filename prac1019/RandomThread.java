package prac1019;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

class RandomThread01 extends Thread{
	private Container contentPane;
	private boolean flag=false; // �������� ���� ����� ǥ���ϴ� �÷��� , true:��������
	
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
			//���̺��� ����Ʈ�� ���� ������ ��ġ�� ����
			label.setLocation(x, y);
			//���̺��� ����Ʈ�ҿ� �߰�
			contentPane.add(label);
			//����Ʈ���� �ٽ� �׷� �߰��� ���̺��� ���̰� �� 
			contentPane.repaint();
			
			try {
				//0.3�� ���� ���� �Ѵ� 
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
					//RandomThread ���� ���
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
	
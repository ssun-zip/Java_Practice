package practice1015;

import java.awt.*;

import javax.swing.*;

public class CountDownTest extends JFrame{
	private JLabel label;
	class MyThread extends Thread {
		public void run() {
			for(int i = 10; i >= 0; i--) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				label.setText( i + " ");
			}
		}
	}


	public CountDownTest(){
			setTitle("카운트다운");
			setSize(300,200);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			label = new JLabel ("Start");
			label.setFont(new Font("Serif", Font.BOLD, 100));
			add(label);
			setVisible(true);
	}
	public static void main(String[] args) {
		CountDownTest t = new CountDownTest();
	}

}
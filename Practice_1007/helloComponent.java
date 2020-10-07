package Practice_1007;
//상, 하, 좌, 우 키를 이용하여 "HELLO" 문자열을 움직이는 응용프로그램을 작성하라.

import java.awt.event.*;
import javax.swing.*;

class MyPanel3 extends JPanel {
	JLabel label;
	int x = 0, y = 0;

	public MyPanel3() {
		//JPanel uses a default FlowLayout --> setBounds() 이용 불가
		// absolute layout
		//배치관리자를 null로 설
		setLayout(null);
		label = new JLabel("Hello");
		add(label);
		// setBounds(x, y, 가로,세로크기)
		label.setBounds(50, 50, 100, 20);
		/* 혹은 setLocation & setSize 조합으로 컵포넌트 위치 크기 지정
		 * 하나만 작성하면 뜨지않을수있다.
		 
			label.setLocation(50, 50);
			label.setSize(100, 20);
		*/


		addKeyListener(new KeyAdapter() {
			// 방향키로 이미지 움직이기
			public void keyPressed(KeyEvent e) {
				int keycode = e.getKeyCode();
				switch (keycode) {
				case KeyEvent.VK_UP:
					y -= 10;
					break;
				case KeyEvent.VK_DOWN:
					y += 10;
					break;
				case KeyEvent.VK_LEFT:
					x -= 10;
					break;
				case KeyEvent.VK_RIGHT:
					x += 10;
					break;
				}
				setLocation(x, y);
			}

		});
		// 키 입력시 팬에 포커스 지정
		this.requestFocus();
		setFocusable(true);
	}
}

public class helloComponent extends JFrame {
	public helloComponent() {
		setSize(300, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new MyPanel3());
		setVisible(true);
	}

	public static void main(String[] args) {
		new helloComponent();
	}
}

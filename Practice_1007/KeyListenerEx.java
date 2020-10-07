package Practice_1007;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class KeyListenerEx extends JFrame{
	//keyMessage가 저장되있는 Label들의 list 만들기
	private JLabel[] keyMessage;
	
	public KeyListenerEx() {
		setTitle("keyListener 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// this.getContentPane() 과 동일함
		//content pane layer을 실행시켜주며 component를 넣을수있는 배경 제공.
		Container c  = getContentPane();
		//flowLayout -> wrap up content; 가장 작게 맞춰버리는
		c.setLayout(new FlowLayout());
		
		c.addKeyListener(new MyKeyListener());
		
		// keyMessage list 에 넣기 
		keyMessage = new JLabel[3];
		keyMessage[0] = new JLabel(" getKeyCode() ");
		keyMessage[1] = new JLabel(" getKeyChar() ");
		keyMessage[2] = new JLabel(" getKeyuText() ");
		
		//컨테이너에 메세지 하나씩 프린트하고 노란 뒷배
		for(int i = 0; i < keyMessage.length; i++) {
			c.add(keyMessage[i]);
			keyMessage[i].setOpaque(true);
			keyMessage[i].setBackground(Color.YELLOW);
		}
		setSize(300, 150);
		setVisible(true);
		
		c.setFocusable(true);
		c.requestFocus();
	}
	
	class MyKeyListener extends KeyAdapter {
		public void keyPressed (KeyEvent e) {
			//event's keyCode 와 연관되있는 숫자 리턴 
			int keyCode = e.getKeyCode();
			//Key 이벤트에 글자를 리턴 
			char keyChar = e.getKeyChar();
			
			keyMessage[0].setText(Integer.toString(keyCode));
			keyMessage[1].setText(Character.toString(keyChar));
			//KeyCode를 설명해주는 String 리턴 ->  예시 "HOME", "F1" or "A".
			keyMessage[2].setText(e.getKeyText(keyCode));	
		}
	}

	public static void main(String[] args) {
		new KeyListenerEx();
	}

}

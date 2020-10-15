package practice1015;

import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class VibratingFrame_01 extends JFrame implements Runnable{
	
	Thread th;
	
	public VibratingFrame_01() {
		setTitle("진동하는 프레임 만들기");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300,300);
		setVisible(true);
		
		getContentPane().addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if(!th.isAlive()) return;
				th.interrupt();
				/* 
				 * interrupt 하나의 스레드가 실행하고 있는 작업을 중지
				 * 근데 만약 스레드가 실행중에도 한벉도 sleep()을 호출하지 않는다면
				 * Interrupted Exception을 받지 못한다.
				 * 이런 경우에는 무한 루프 중간에 다음과 같인 인터럽트를 검사해 주는것이 좋다
				 */
			}
		});
		th = new Thread(this); //진동하는 스레드 객체 생성
		th.start(); //스레드 시작 -> run() : 진동 시작
	}
	
	public void run() {
		Random r = new Random();
		while(true) {
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// catch 예외가 발생했을때 이 부분으로 이어진다
				//예외를 받고 스스로 리턴하여 종료
				return; 
			}
			int x = getX() + r.nextInt() % 50;
			int y = getY() + r.nextInt() % 50;
			setLocation(x, y);
			//에러를 잡기위해 try catch 구문을이용
			//finally 코드 없이 작성할수있다.

		}
	}
	public static void main(String[] args) {
		new VibratingFrame_01();
	}

}

package practice_0929;
import javax.swing.*;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;

public class Button1 extends JFrame{
	Button1(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("대박");
		setLayout(new FlowLayout());
		
		Button btn1 = new Button("가위");
		Button btn2 = new Button("바위");
		Button btn3 = new Button("보");
		
		add(btn1);
		add(btn2);
		add(btn3);
		
		btn1.setBackground(Color.CYAN);
		btn3.setForeground(Color.RED);
		btn2.setEnabled(false); //바위 사용안함
		
		setBackground(Color.PINK);
		setForeground(Color.BLUE);
		
		setSize(200, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Button1();
	}
	//main() 메소드에서 button1 클래스 생성
	// Button1() 생성자가 실행되므로 windows창이 출력
	//한글깨진것에대한 에러 잡기:
	//-Dfile.encoding=MS949

}

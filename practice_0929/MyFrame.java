package practice_0929;
import javax.swing.*;
// JButton & JFrame 모두 
import java.awt.FlowLayout;

public class MyFrame extends JFrame{
	public MyFrame() {
		// swing받아 화면 도화지 출력 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("FlowLayoutTest");
		
		JPanel panel;
		panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		//패널에 버튼 생성 추가
		panel.add(new JButton("Button1"));
		panel.add(new JButton("Button2"));
		panel.add(new JButton("Button3"));
		panel.add(new JButton("B4"));
		panel.add(new JButton("Long Button5"));
		add(panel);
		
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		MyFrame f = new MyFrame();
	}

}

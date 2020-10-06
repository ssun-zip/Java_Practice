package Practice_1006;
import javax.swing.*;

// myFrame using lambda expression 

public class MyFrame2 extends JFrame{
	private JButton button;
	private JLabel label;
	
	public MyFrame2() {
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("이벤트 예제");
		
		JPanel panel = new JPanel();
		button = new JButton("버튼을 누르시오");
		label = new JLabel("아직 버튼이 눌러지지 않았습니다");
		button.addActionListener(e -> {
			label.setText("마침내 버튼이 눌려졌습니다");
		});
		panel.add(button);
		panel.add(label);
		this.add(panel);
		this.setVisible(true);
	}
}

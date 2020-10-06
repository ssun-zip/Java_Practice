package Practice_1006;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MyFramee extends JFrame {
	private JButton button1;
	private JButton button2;
	private JPanel panel;

	public MyFramee() {
		setTitle("이벤트 예제");
		setSize(300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		panel = new JPanel();

		button1 = new JButton("노란색");
		button1.addActionListener(new MyListener());
		panel.add(button1);
		button2 = new JButton("핑크색");
		button2.addActionListener(new MyListener());
		panel.add(button2);

		this.add(panel);
		this.setVisible(true);
	}

	private class MyListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == button1) {
				panel.setBackground(Color.YELLOW);
			} else if (e.getSource() == button2) {
				panel.setBackground(Color.PINK);
			}
		}
	}
}

public class MyFrame3 {
	public static void main(String[] args) {
		MyFramee t = new MyFramee();
	}
}

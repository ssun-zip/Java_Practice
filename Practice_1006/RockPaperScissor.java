package Practice_1006;
import java.awt.*;
//import event listener 
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class RockPaperScissor extends JFrame implements ActionListener {
	static final int ROCK = 0;
	static final int PAPER = 0;
	static final int SCISSOR = 0;
	private JPanel panel;
	private JTextField output;
	private JTextField information;
	private JButton rock;
	private JButton paper;
	private JButton scissor;
	
	public RockPaperScissor() {
		setTitle("가위, 바위, 보");
		setSize(400, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		panel = new JPanel();
		panel.setLayout(new GridLayout(0,3));
		information = new JTextField("아래의 버튼 중에서 하나 클릭하시오!");
		output = new JTextField(20);
		rock = new JButton("ROCK");
		paper = new JButton("PAPER");
		scissor = new JButton("SCISSOR");
		
		rock.addActionListener(this);
		paper.addActionListener(this);
		scissor.addActionListener(this);
		
		panel.add(rock);
		panel.add(paper);
		panel.add(scissor);
		
		add(information, BorderLayout.NORTH);
		add(panel, BorderLayout.CENTER);
		add(output, BorderLayout.SOUTH);
		setVisible(true);	
	}
	
	public static void main(String[] agrs) {
		RockPaperScissor gui =  new RockPaperScissor();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Random rand = new Random();
		int com = rand.nextInt(3);
		if(e.getSource() == rock) {
			if(com == SCISSOR) {
				output.setText("사용자가 승리");
			} else if(com == ROCK) {
				output.setText("비겼음");
			} else {
				output.setText("컴퓨터 승리");
			}
		} else if (e.getSource() == paper) {
			if(com == ROCK) {
				output.setText("사용자가 승리");
			} else if(com == PAPER) {
				output.setText("비겼음");
			} else {
				output.setText("컴퓨터 승리");
			}
		} else if (e.getSource() == scissor) {
			if(com == PAPER) {
				output.setText("사용자가 승리");
			} else if(com == SCISSOR) {
				output.setText("비겼음");
			} else {
				output.setText("컴퓨터 승리");
			}
		}
	}

}

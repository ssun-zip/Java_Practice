package homework;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

class MyPanel extends JPanel implements ActionListener{
	private JTextField field;
	private JPanel panel;
	private JButton[] buttons;
	private String[] labels = {"Backspace", "", "", "CF","C","7","8","9","/","sqt","4", "5", "6",
								"x", "%", "1","2","3","-", "1/x", "0", "-/+",".", "+","="};
	private double result = 0;
	private String operator = "=";
	private boolean startOfNumber = true;
	
	MyPanel(){
		field = new JTextField(30);
		field.setText("0.0");
		// make separate panel displaying 자판 into Grid
		panel = new JPanel();
		panel.setLayout(new GridLayout(5,5));
		// generate 5 new buttons 
		buttons = new JButton[25];
		
		int index = 0;
		//row
		for(int i = 0; i < 5; i++) {
			//column
			for( int j = 0; j < 5; j++) {
				//set the given position of the button as the 
				//label on the given string 
				buttons[index] = new JButton(labels[index]);
				if(j >= 3) {
					buttons[index].setForeground(Color.RED);
				} else {
					buttons[index].setForeground(Color.BLUE);
					buttons[index].setBackground(Color.yellow);
				}
				panel.add(buttons[index]);
				buttons[index].addActionListener(this);
				index++;		
			}
		}
		//need to set the layout first in order to 
		// apply the settings
		setLayout(new BorderLayout ());
		// set the field on the top and panel on the bottom center
		add(field, BorderLayout.NORTH);
		add(panel, BorderLayout.CENTER);
	}
	
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if(command.charAt(0) == 'C') {
			startOfNumber = true;
			result = 0;
			operator = "=";
			field.setText("0.0");
		} else if (command.charAt(0) >= '0' && command.charAt(0) <= '9' 
				|| command.equals(".")) {
			// if enetered a number or . just keep on writing the text
			// 213.4 -> press 2-> 1 -> 3-> . -> 4
			if(startOfNumber == true) {
				// 첫숫자일경우에는 그전 숫자와 연결시키지 않기 
				field.setText(command);;
			} else {
				field.setText(field.getText() + command);
			}
			startOfNumber = false;
		} else {
			if(startOfNumber) {
				if(command.equals("-")) {
					field.setText(command);;
					startOfNumber = false;
				} else {
					operator = command;
				}
			} else {
				double x = Double.parseDouble(field.getText());
				calculate(x);
				operator = command;
				startOfNumber = true;
			}
		}
	}
	
	private void calculate(double n) {
		if(operator.equals("+")) {
			result += n;
		} else if(operator.equals("-")) {
			result -= n;
		} else if(operator.equals("*")) {
			result *= n;
		} else if(operator.equals("/")) {
			result /= n;
		} else if(operator.equals("=")) {
			result = n;
		}
		
		field.setText("" + result);
		
		// no result for input string: "1/x"
		// NumberFormatException 
	}
}

public class Calculator extends JFrame{

	public Calculator() {
		add(new MyPanel());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		// resize them fit the contents
		// pack()을 쓸경우 setSize()를 부르지않아도됨 
		pack();
	}

	public static void main(String[] args) {
		new Calculator();

	}

}

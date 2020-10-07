package Practice_1007;

//리스너 이용 예제

import java.awt.*;
import java.awt.event.*;
//import java.awt.image.BufferedImage;
//import java.io.*;
//import javax.imageio.ImageIO;
import javax.swing.*;

class MyPanel extends JPanel {
	//BufferedImage img = null;
	JLabel label;
	//초기값은 어떤 숫자여도 상관없다 initialize with any number
	int img_x = 0, img_y = 0;
	
	public MyPanel() {
		/*
		try {
			// workspace > 프로젝트에 바로 사진 저장 
			img = ImageIO.read(new File("car2.gif"));
			
		} catch (IOException e) {
			System.out.println("no image");
			System.exit(1);
		}
		*/
		label = new JLabel("Hello");
		add(label);
		
		addMouseListener(new MouseListener() {
			//컴포넌트 위에서 눌러지면 호출
			public void mousePressed(MouseEvent e) {
				img_x = e.getX();
				img_y = e.getY();
				// img : repaint
				// label : setLocation
				// setLocation만쓰면 엉뚱한 위치로 갈수있음. label이라고 지정해주어야함. 
				label.setLocation(img_x, img_y);
			}
			// 컴포넌트에서 떼어지면 호출
			public void mouseReleased(MouseEvent e) {}

			//컴포넌트에 들어가면 호출
			public void mouseEntered(MouseEvent e) {}
			
			//컴포넌트에 나가면 호출
			public void mouseExited(MouseEvent e) {}
			
			// 컴포넌트를 클릭한 경우에 호출
			public void mouseClicked(MouseEvent e) {}
		});
	}
	

	//repaint() 의 overriding method
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//g.drawImage(img, img_x, img_y, null);
	}
		
}

public class MyFrameCar extends JFrame{
	public MyFrameCar() {
		add(new MyPanel());
		setSize(300,500);
		setVisible(true);
	}
	
	public static void main(String[] arg) {
		new MyFrameCar();
	}
}

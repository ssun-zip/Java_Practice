package Practice_1007;

//adapter 이용 car test 

import javax.swing.*;

import java.awt.Graphics;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

class MyPanell extends JPanel {
	BufferedImage img = null;
	int img_x = 0, img_y = 0;
	
	public MyPanell() {
		try {
			// workspace > 프로젝트에 바로 사진 저장 
			img = ImageIO.read(new File("car2.gif"));
			
		} catch (IOException e) {
			System.out.println("no image");
			System.exit(1);
		}
		
		addMouseListener(new MouseAdapter() {
			//컴포넌트 위에서 눌러지면 호출
			public void mousePressed(MouseEvent e) {
				img_x = e.getX();
				img_y = e.getY();
				repaint();
			}
		});
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, img_x, img_y, null);
	}
}

public class CarTest extends JFrame{
	public CarTest() {
		add(new MyPanell());
		setSize(300,500);
		setVisible(true);
	}
	
	public static void main(String[] arg) {
		new CarTest();
	}

}

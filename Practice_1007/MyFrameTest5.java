package Practice_1007;


import java.awt.event.*;
import javax.swing.*;

class MyFrame extends JFrame implements MouseListener, MouseMotionListener{
	public MyFrame() {
		setTitle("Mouse Event");
		setSize(300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		
		panel.addMouseListener(this);
		panel.addMouseMotionListener(this);
		add(panel);
		setVisible(true);
	}
	
	// 위에서 눌러지면 호출
	public void mousePressed(MouseEvent e) {
		display("Mouse pressed(# of clicks: " + e.getClickCount() + ")", e);
	}

	//컴포넌트에서 떼어지면 호출
	public void mouseReleased(MouseEvent e) {
		display("Mouse released(# of clicks: " + e.getClickCount() + ")", e);
	}

	//컴포넌트에 들어가면 호출
	public void mouseEntered(MouseEvent e) {
		display("Mouse entered", e);
	}
	
	//컴포넌트에 나가면 호출
	public void mouseExited(MouseEvent e) {
		display("Mouse exited", e);
	}
	
	// 컴포넌트를 클릭한 경우에 호출
	public void mouseClicked(MouseEvent e) {
		display("Mouse clicked (# of clicks: " + e.getClickCount() + ")", e);
	}
	
	// 출력값 display
	protected void display(String s, MouseEvent e) {
		System.out.println(s + "X=" + e.getX() + "Y=" + e.getY());
	}
	
	// 드래그하면 호출된다 
	public void mouseDragged(MouseEvent e) {
		display("Mouse dragged", e);
	}
	
	// 마우스가 클릭되지 않고 이동하는 경우 호출
	public void mouseMoved(MouseEvent e) {
		display("Mouse moved", e);
	}
}

public class MyFrameTest5 {

	public static void main(String[] args) {
		MyFrame f = new MyFrame();
	}

}

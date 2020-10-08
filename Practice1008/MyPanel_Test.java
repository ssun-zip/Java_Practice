package Practice1008;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*; //JPanel , Timer 

class MyPanel_02 extends JPanel implements ActionListener {
	private final int WIDTH = 500;
	private final int HEIGHT = 300;
	private final int START_A = 0;
	private final int START_B = 250;
	private BufferedImage image;
	private Timer timer;
	private int x,y;
	
	public MyPanel_02() {
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setDoubleBuffered(true);
		
		File input = new File("c:\\temp\\ship.jpg");
		try {
			image = ImageIO.read(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		x = START_A;
		y = START_B;
		
		timer = new Timer(1, this);
		timer.start();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, x, y, this);
	}
	//이미지를 화면에 그린다
	
	@Override
	//타이머이벤트 발생하면
	public void actionPerformed(ActionEvent e) {
		// 위로 오른쪽 대각선방향으로 움직이기
		x += 1;
		y -= 1;
		
		// 프레임에서 벗어나면 다시 원위치부터 시작 
		if (x > WIDTH) {
			x = START_A;
			y = START_B;
			
		}
		//화면에 다시 그리기 하다
		repaint();
	}
}
public class MyPanel_Test extends JFrame{
	public MyPanel_Test() {
		//패널에 프레임 추가
		add(new MyPanel_02());
		setTitle("애니메이션 테스트");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 300);
		setVisible(true);
	}

	public static void main(String[] args) {		
		new MyPanel_Test();
	}

}

package weekendHomework;

/*
 * 이 프로그램은 아무 자반이나 누르거나 꾸욱 누르게되 노란색 bar부분이
 * 핑크색으로 채워지는 프로그램이다. 
 * 아무것도 누르지않으면 다시 핑크색으로 차올랐던 부분이 자연스럽게
 * 줄어드는 것을 볼수있다.
 */

//color. container, graphics
import java.awt.*;
//Keyadapter, Keyevent
import java.awt.event.*;
//JFrame, JLabel
import javax.swing.*;

class MyLabel extends JLabel {
	int barSize = 0; //바 크기
	int maxBarSize;

	MyLabel(int maxBarSize) {
		this.maxBarSize = maxBarSize;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.MAGENTA);
		
		//현재의 width / (바크기 * 전체 바의 크기)
		int width = (int) (((double) (this.getWidth())) / maxBarSize * barSize);
		if (width == 0)//크기가 0이기 때문에 바를 그릴 필요가 없음
			return;
		g.fillRect(0, 0, width, this.getHeight());
	}
	//Synchronized methods enable a simple strategy for preventing thread interference and 
	//memory consistency errors: if an object is visible to more than one thread, 
	//all reads or writes to that object's variables are done through synchronized methods.
	synchronized void fill() {
		if (barSize == maxBarSize) {
			try {
				wait();//바의 크기가 최대이면,ConsumerThread에 의해 바의 크기가 줄어들때 까지 대기
			} catch (InterruptedException e) {
				return;
			}
		}
		barSize++;
		repaint();//바 다시 그리기
		notify();//기다리는 ConsumerThread스레드 꺠우기
	}

	//아무 키도 작동하지않는 경우 바의 크기 줄어들게 작동시키기
	synchronized void consume() {
		//바의 크기가 0이여서 더이상 작아질수없는경우라면 기다리
		if (barSize == 0) {
			try {
				wait();//바의 크기가 0이면 바의크기가 0보다 커질때 까지 대기
			} catch (InterruptedException e) {
				return;
			}
		}
		// 바의 사이즈 줄어들기. 
		barSize--;
		repaint();//바 다시 그리기
		notify();//기다리는 이벤트 스레드 깨우기
	}
}

// consumerThread는 JMS message를 지속적으로 receive()를 통해 받아들이고 처리한다.  
class ConsumerThread extends Thread {
	MyLabel bar;

	ConsumerThread(MyLabel bar) {
		this.bar = bar;
	}

	public void run() {
		while (true) {
			try {
				// 현재의 쓰레드를 특정시간동안 실행을 멈추는 역할을 함. 
				// milisecond 
				sleep(200);
				// 특정경우 key listener를 작동시키지 않는 역할을 한다. 
				bar.consume();//0.1초마다 바를 1씩 줄인다.
			} catch (InterruptedException e) {
				return;
			}
		}
	}
}

public class TabAndThreadEx extends JFrame {
	MyLabel bar = new MyLabel(100);//바의 최대크기를 100으로 설정

	TabAndThreadEx(String title) {
		// main method에서 받아온 string "아무거나 빨리 눌러바 채우기를"
		// 제목으로 지
		super(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//ContentPane 오브젝트를 프레임으로 리턴한다. 
		Container c = getContentPane();
		//componen의 사이즈나 위치 지정을 null
		c.setLayout(null);
		bar.setBackground(Color.ORANGE);
		bar.setOpaque(true);//그림을 표시하게 설정,투명도 조절
		bar.setLocation(20, 50);
		bar.setSize(300, 200);//300*20크기의 바
		c.add(bar);
		c.addKeyListener(new KeyAdapter() {//컨텐트팬에 키 이벤트 핸들러 등록
			public void keyPressed(KeyEvent e) {
				bar.fill();//키를 누를때 마다 바가 1씩 증가
			}
		});
		setSize(350, 200);
		setVisible(true);
		c.requestFocus();//컨텐트팬에게 키 처리권 부여
		ConsumerThread th = new ConsumerThread(bar);//스레드 생성
		th.start();//스레드 시작
	}

	public static void main(String[] args) {
		new TabAndThreadEx("아무거나 빨리 눌러 바 채우기");
	}
}

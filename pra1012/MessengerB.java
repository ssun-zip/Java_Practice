package pra1012;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import pra1012.MessengerA.MyFrame;

public class MessengerB {
	protected JTextField textField;
	protected JTextArea textArea;
	DatagramSocket socket;
	DatagramPacket packet;
	InetAddress address = null;
	final int myPort = 6000; //수신용 포트
	final int otherPort = 5000; //송신용 포트
	
	public MessengerB() throws IOException{
		MyFrame f = new MyFrame();
		address = InetAddress.getByName("127.0.0.1");
		socket = new DatagramSocket(myPort);
	}
	
	public void process() {
		while(true) {
			try {
				byte[] buf = new byte[256];
				packet = new DatagramPacket(buf, buf.length);
				socket.receive(packet); //패킷을 받는다
				//받은 패킷을 텍스트영역에 표시한다
				textArea.append("RECEIVED: " + new String(buf) + "\n");
			} catch (IOException ioExcpetion) {
				ioExcpetion.printStackTrace();
			}
		}
	}
	
	class MyFrame extends JFrame implements ActionListener{
		public MyFrame() {
			super("MessengerB");
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			
			textField = new JTextField(30);
			textField.addActionListener(this);
			
			textArea = new JTextArea(10,30);
			textArea.setEditable(false);
			
			add(textField, BorderLayout.PAGE_END);
			add(textArea, BorderLayout.CENTER);
			pack();
			setVisible(true);
		}
		
		public void actionPerformed(ActionEvent ef) {
			String s = textField.getText();
			byte[] buf = s.getBytes();
			DatagramPacket packet;
			
			//패킷 생성
			packet = new DatagramPacket(buf, buf.length, address, otherPort);
			
			try {
				socket.send(packet);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) throws IOException {
		MessengerB m = new MessengerB();
		m.process();
	}

}

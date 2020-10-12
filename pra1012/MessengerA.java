package pra1012;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

import javax.swing.*;

public class MessengerA {
	protected JTextField textField;
	protected JTextArea textArea;
	DatagramSocket socket;
	DatagramPacket packet;
	InetAddress address = null;
	final int myPort = 5000; //수신용 포트
	final int otherPort = 6000; //송신용 포트
	
	public MessengerA() throws IOException{
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
			super("MessengerA");
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			
			textField = new JTextField(30);
			textField.addActionListener(this);
			
			textArea = new JTextArea(10,20);
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
		MessengerA m = new MessengerA();
		m.process();
	}

}

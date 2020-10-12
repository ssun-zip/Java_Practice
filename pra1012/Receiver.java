package pra1012;

import java.io.*;
import java.net.*;

public class Receiver {

	public static void main(String[] args) throws IOException{
		byte[] buf = new byte[2567];
		
		//포트 번호: 5000
		DatagramSocket socket = new DatagramSocket(5000);
		// buf의 길이만큼을 받아들일수있는 packet 생성 
		DatagramPacket packet = new DatagramPacket(buf, buf.length);
		socket.receive(packet);
		System.out.println(new String(buf));
	}

}

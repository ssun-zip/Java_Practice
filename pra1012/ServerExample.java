package pra1012;

import java.io.*;
import java.net.*;

public class ServerExample {

	public static void main(String[] args) {
		ServerSocket ss = null;
		try {
			ss = new ServerSocket();
			ss.bind(new InetSocketAddress("192.168.0.93", 5001));
			//IP와 포트번호로 서버소켓 생성 서버측에서 보낸신호가 클라이언트에서 보게 된다.
			while(true) {
				System.out.println("[연결 기다림]");
				Socket socket = ss.accept();
				InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
				//연결 수락후 client측 정보확인
				System.out.println("[연결 수락함]" + isa.getHostName()); //클라이언트 주소확인
			}
		} catch (Exception e) {}
		
		if(!ss.isClosed()) {
			try {
				ss.close();
			} catch (IOException el) {}
			}
		}

}

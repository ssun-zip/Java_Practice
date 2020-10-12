package pra1012;

import java.io.*;
import java.net.*;

public class SimpleServer {

	public static void main(String[] args) {
		BufferedWriter bw;
		PrintWriter pw = null;
		OutputStream os;
		ServerSocket serverSocket;
		Socket s1 = null;
		InetAddress ipAddrs = null;
		String connectedClient = null;
		String outMessage = null;
		
		try {
			serverSocket = new ServerSocket(5432);
			System.out.println("서버 실행중....");
			while(true) {
				//클라이언트 접속 요청시 소켓 객체를 생성 
				s1 = serverSocket.accept();
				os = s1.getOutputStream();
				ipAddrs = s1.getInetAddress();
				connectedClient = ipAddrs.toString();
				bw = new BufferedWriter(new OutputStreamWriter(os));
				pw = new PrintWriter(bw, true);
				pw.println(connectedClient +"에서 서버에 접속하였습니다.");
				pw.close();
				s1.close();
			}
		} catch (IOException ie) {
			ie.printStackTrace();
		}
	}

}

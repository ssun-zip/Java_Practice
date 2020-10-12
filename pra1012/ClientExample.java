package pra1012;

import java.io.IOException;
import java.net.*;

public class ClientExample {

	public static void main(String[] args) {
		Socket socket = null;
		try {
			socket = new Socket(); // 클라이언트 소켓 생성
			System.out.println("[연결 요청]");
			socket.connect(new InetSocketAddress("192.168.0.93", 5001));
			System.out.println("[연결 성공]");
		} catch (Exception e) {
		}

		if (!socket.isClosed()) {
			try {
				socket.close();
			} catch (IOException el) {
			}
		}
	}
}

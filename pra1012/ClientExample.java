package pra1012;

import java.io.IOException;
import java.net.*;

public class ClientExample {

	public static void main(String[] args) {
		Socket socket = null;
		try {
			socket = new Socket(); // Ŭ���̾�Ʈ ���� ����
			System.out.println("[���� ��û]");
			socket.connect(new InetSocketAddress("192.168.0.93", 5001));
			System.out.println("[���� ����]");
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

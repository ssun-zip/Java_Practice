package pac201020;

import java.net.*;
import java.io.*;

public class SendThread extends Thread {
	Socket socket;
	String name;
	PrintWriter pw;

	public SendThread(Socket socket, String name) {
		this.socket = socket;
		this.name = name;
	}

	public void run() {
		BufferedReader br = // BufferedReader���پ� �д°�
		new BufferedReader(new InputStreamReader(System.in));// Stream �Ѳ�����
		try {
			pw = new PrintWriter(socket.getOutputStream());
			pw.println(name);
			pw.flush();
			while (true) {
				// ������ �ؽ�Ʈ�� �޾Ƶ�� �д´� 
				String msg = br.readLine();
				if (msg.equals("bye"))
					break;
				// �޼����� ����Ѵ�. 
				pw.println(msg);
				pw.flush();
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
			}
		}
	}
}


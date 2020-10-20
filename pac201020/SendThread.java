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
		BufferedReader br = // BufferedReader한줄씩 읽는것
		new BufferedReader(new InputStreamReader(System.in));// Stream 한꺼번에
		try {
			pw = new PrintWriter(socket.getOutputStream());
			pw.println(name);
			pw.flush();
			while (true) {
				// 쓰여진 텍스트를 받아드려 읽는다 
				String msg = br.readLine();
				if (msg.equals("bye"))
					break;
				// 메세질글 출력한다. 
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


package pac201020;

import java.net.*;
import java.util.*;
import java.io.*;

public class PerClient extends Thread {
	static List<PrintWriter> list = Collections.synchronizedList(new ArrayList<>());
	// 동시에작업안함 synchronized
	Socket client;
	PrintWriter pw;// 연결통로Writer

	public PerClient(Socket client) throws IOException {
		this.client = client;
		pw = new PrintWriter(client.getOutputStream());
		list.add(pw);
	}

	public void run() {
		String name = "";
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
			name = br.readLine();
			// 사용자가 입장하였음을 출력 
			sendAll("# " + name + "님이 입장하셨습니다");
			while (true) {
				// 쓰여진 메세지를 받아드린다
				String msg = br.readLine();
				if (msg == null)
					break;
				//이름과 함꼐 사용자가 쓴 메세지를 출력해준다. 
				sendAll(name + " > " + msg);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			// 사용자가 퇴장하게되면 리스트의 정보들을 삭제하고
			// 사용자가 퇴장하였음을 춝력해준다. 
			list.remove(pw);
			sendAll("# " + name + "님이 퇴장하셨습니다");
			try {
				client.close();
			} catch (Exception e) {
			}
		}
	}

	void sendAll(String msg) {
		for (PrintWriter p : list) {
			p.println(msg);
			p.flush();
		}
	}
}
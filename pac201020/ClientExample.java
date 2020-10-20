package pac201020;

import java.net.Socket;
import java.util.Scanner;
public class ClientExample {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 타이핑한 ip주소를 저장한다. 
		System.out.println("연결한 IP ?");
		String ip = sc.nextLine();
		System.out.println("사용한 별명은 ?");
		String name = sc.nextLine();
		try {
			Socket socket = new Socket(ip, 9002);
			// 쓰레드를 주어진 ip로부터 입력받는다. 
			ReceiveThread rt = new ReceiveThread(socket);
			SendThread st = new SendThread(socket,name);
			//스레드를 시작시켜주는 부분 필요
			rt.start();
			st.start();
			
		} catch(Exception e) { 
			System.out.println(e.getMessage());			
		} 
	}
}

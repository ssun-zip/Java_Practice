package pac201020;

import java.net.Socket;
import java.util.Scanner;
public class ClientExample {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// Ÿ������ ip�ּҸ� �����Ѵ�. 
		System.out.println("������ IP ?");
		String ip = sc.nextLine();
		System.out.println("����� ������ ?");
		String name = sc.nextLine();
		try {
			Socket socket = new Socket(ip, 9002);
			// �����带 �־��� ip�κ��� �Է¹޴´�. 
			ReceiveThread rt = new ReceiveThread(socket);
			SendThread st = new SendThread(socket,name);
			//�����带 ���۽����ִ� �κ� �ʿ�
			rt.start();
			st.start();
			
		} catch(Exception e) { 
			System.out.println(e.getMessage());			
		} 
	}
}

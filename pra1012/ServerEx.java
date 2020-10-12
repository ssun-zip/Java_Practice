package pra1012;

import java.io.*;
import java.net.*;
import java.util.*;

public class ServerEx {

	public static void main(String[] args) {
		BufferedReader in = null;
		BufferedWriter out = null;
		ServerSocket listener = null;
		Socket socket = null;
		Scanner sc = new Scanner(System.in);
		
		try {
			listener = new ServerSocket(9999); //���� ���� ����
			System.out.println("������ ��ٸ����ֽ��ϴ� ....");
			socket = listener.accept();
			System.out.println("����Ǿ����ϴ�");
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter( new OutputStreamWriter(socket.getOutputStream()));
			
			while(true) {
				String inputMessage = in.readLine();
				if(inputMessage.equalsIgnoreCase("bye")) {
					System.out.println("Ŭ���̾�Ʈ���� bye�� ������ �����Ͽ���");
					break; //bye�̸� ���� ����
				}
				System.out.println("����: " + inputMessage); //���� �޼����� ȭ�鿡 ���
				System.out.println("������>> "); //������Ʈ
				String outputMessage = sc.nextLine(); //Ű���忡�� �� ���� ���ڿ� ����
				out.write(outputMessage + "\n"); //Ű���� ���� ���ڿ� ����
				out.flush();
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				sc.close();
				socket.close();
				listener.close();
			} catch (IOException e) {
				System.out.println("Ŭ���̾�Ʈ�� ä���� ������ �߻��߽��ϴ�");
			}
		}
	}

}

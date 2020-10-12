package pra1012;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ClientEx {

	public static void main(String[] args) {
		BufferedReader in = null;
		BufferedWriter out = null;
		ServerSocket listener = null;
		Socket socket = null;
		Scanner sc = new Scanner(System.in);
		
		try {
			socket = new Socket("localhost", 9999); //���� ���� ����
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter( new OutputStreamWriter(socket.getOutputStream()));
			
			//���� ��� ��Ʈ��
			while(true) {
				System.out.println("������>> "); //������Ʈ
				String outputMessage = sc.nextLine();
				if(outputMessage.equalsIgnoreCase("bye")) {
					out.write(outputMessage + "\n"); //Ű���� ���� ���ڿ� ����
					out.flush();
					break;
				}
				out.write(outputMessage + "\n"); //Ű���� ���� ���ڿ� ����
				out.flush();
				String inputMessage = in.readLine();
				//������ ���� �޼����� ȭ�鿡 ��� 
				System.out.println("����: " + inputMessage);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				sc.close();
				if(socket != null ) {
					socket.close();
				}
			} catch (IOException e) {
				System.out.println("������ ä���� ������ �߻��߽��ϴ�");
			}
		}	
	}

}

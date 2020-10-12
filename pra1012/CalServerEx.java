package pra1012;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class CalServerEx {

	public static void main(String[] args) {
		BufferedReader in = null;
		BufferedWriter out = null;
		ServerSocket listener = null;
		Socket socket = null;
		
		try {
			listener = new ServerSocket(9999); //���� ���� ����
			System.out.println("������ ��ٸ����ֽ��ϴ� ....");
			socket = listener.accept();
			System.out.println("����Ǿ����ϴ�");
			in = new BufferedReader(new InputStreamReader(socket.
									getInputStream()));
			out = new BufferedWriter( new OutputStreamWriter
										(socket.getOutputStream()));
			
			while(true) {
				String inputMessage = in.readLine();
				if(inputMessage.equalsIgnoreCase("bye")) {
					System.out.println("bye�� ������ �����Ͽ���");
					break; //bye�̸� ���� ����
				}
				System.out.println(inputMessage);
					 //���� �޼����� ȭ�鿡 ���
				String result = calc(inputMessage);
				out.write(result + "\n"); //Ű���� ���� ���ڿ� ����
				out.flush();
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				socket.close();
				listener.close();
			} catch (IOException e) {
				System.out.println("Ŭ���̾�Ʈ�� ä���� ������ �߻��߽��ϴ�");
			}
		}
	}
	
	public static String calc (String ex) {
		Scanner token = new Scanner(ex);
		int result = token.nextInt();
		while(token.hasNext()) {
			String operator = token.next();
			int op2 =  token.nextInt();
			switch (operator) {
				case "+" :
					result = result + op2;
					break;
				case "-":
					result = result - op2;
					break;
				case "*":
					result = result * op2;
					break;
			}
		}
		return Integer.toString(result);
	}


}

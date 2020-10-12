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
			listener = new ServerSocket(9999); //서버 소켓 생성
			System.out.println("연결을 기다리고있습니다 ....");
			socket = listener.accept();
			System.out.println("연결되었습니다");
			in = new BufferedReader(new InputStreamReader(socket.
									getInputStream()));
			out = new BufferedWriter( new OutputStreamWriter
										(socket.getOutputStream()));
			
			while(true) {
				String inputMessage = in.readLine();
				if(inputMessage.equalsIgnoreCase("bye")) {
					System.out.println("bye로 연결을 종료하였음");
					break; //bye이면 연결 종료
				}
				System.out.println(inputMessage);
					 //받은 메세지를 화면에 출력
				String result = calc(inputMessage);
				out.write(result + "\n"); //키보드 읽은 문자열 전송
				out.flush();
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				socket.close();
				listener.close();
			} catch (IOException e) {
				System.out.println("클라이언트와 채팅중 오류가 발생했습니다");
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

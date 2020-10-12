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
			listener = new ServerSocket(9999); //서버 소켓 생성
			System.out.println("연결을 기다리고있습니다 ....");
			socket = listener.accept();
			System.out.println("연결되었습니다");
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter( new OutputStreamWriter(socket.getOutputStream()));
			
			while(true) {
				String inputMessage = in.readLine();
				if(inputMessage.equalsIgnoreCase("bye")) {
					System.out.println("클라이언트에서 bye로 연결을 종료하였음");
					break; //bye이면 연결 종료
				}
				System.out.println("서버: " + inputMessage); //받은 메세지를 화면에 출력
				System.out.println("보내기>> "); //프롬프트
				String outputMessage = sc.nextLine(); //키보드에서 한 행의 문자열 읽음
				out.write(outputMessage + "\n"); //키보드 읽은 문자열 전송
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
				System.out.println("클라이언트와 채팅중 오류가 발생했습니다");
			}
		}
	}

}

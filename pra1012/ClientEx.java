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
			socket = new Socket("localhost", 9999); //서버 소켓 생성
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter( new OutputStreamWriter(socket.getOutputStream()));
			
			//소켓 출력 스트림
			while(true) {
				System.out.println("보내기>> "); //프롬프트
				String outputMessage = sc.nextLine();
				if(outputMessage.equalsIgnoreCase("bye")) {
					out.write(outputMessage + "\n"); //키보드 읽은 문자열 전송
					out.flush();
					break;
				}
				out.write(outputMessage + "\n"); //키보드 읽은 문자열 전송
				out.flush();
				String inputMessage = in.readLine();
				//서버로 받은 메세지를 화면에 출력 
				System.out.println("서버: " + inputMessage);
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
				System.out.println("서버와 채팅중 오류가 발생했습니다");
			}
		}	
	}

}

package pra1012;

import java.io.*;
import java.net.*;
import java.util.*;

public class CalcClientEx {

	public static void main(String[] args) {
		BufferedReader in = null;
		BufferedWriter out = null;
		Socket socket = null;
		Scanner scan = new Scanner(System.in);
		
		try {
			socket = new Socket("localhost", 9999);
					in = new BufferedReader( new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			while(true) {
				System.out.println("계산식 (빈칸으로 입력, 예: 24 + 24) >> ");
				String outputMessage = scan.nextLine();
				if(outputMessage.equalsIgnoreCase("bye")) {
					out.write("bye");;
					out.flush();
					break;
				}
				out.write(outputMessage + "\n");
				out.flush();
				String inputMessage = in.readLine();
				System.out.println("계산 결과: " + inputMessage);
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				scan.close();
				if(socket != null) socket.close();
			} catch (IOException e) {
				System.out.println("서버와 채팅중 오류가 발생하였습니다.");
			}
		}
	}

}

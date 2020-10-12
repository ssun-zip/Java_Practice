package pra1012;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("서버 IP");
		String ip = sc.nextLine(); //nextLine() : 줄단위로 입력한 값을 반환
		System.out.println("보낼 메세지");
		String msg = sc.nextLine();
		Socket sk = new Socket(ip, 5005); //Socket(String host, int port)
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter (sk.getOutputStream()));
		bw.write(msg);
		bw.flush();
		bw.close();
		sk.close();
		System.out.println("보내기 성공");
	}

}

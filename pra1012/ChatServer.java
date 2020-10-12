package pra1012;

import java.io.*;
import java.net.*;

public class ChatServer {

	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(5005);
			System.out.println("서버 작동중");
			while(true) {
				Socket client = ss.accept();
				BufferedReader br = new BufferedReader ( new InputStreamReader(client.getInputStream()));
				//reader 한글로 보낼때
				System.out.println(client.getInetAddress() + " > " + br.readLine());
				br.close();
				client.close();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}

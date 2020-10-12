package pra1012;

import java.io.*;
import java.net.*;

public class FileServer_SimpleClient_RecvThread_SimpleServer {

	public static void main(String[] args) {
		InputStream is;
		PrintWriter pw = null;
		ServerSocket serverSocket;
		Socket s1 = null;
		String data;
		BufferedReader br_in;
		
		try {
			// 
			FileWriter writer = new FileWriter("out.txt");
			serverSocket = new ServerSocket(5434);
			System.out.println("서버 실행중...");
			s1 = serverSocket.accept();
			is = s1.getInputStream();
			br_in = new BufferedReader(new InputStreamReader(is));
			pw = new PrintWriter(writer, true);
			while((data = br_in.readLine()) != null) {
				System.out.println(data);
				pw.println();
			}
			writer.close();
			pw.close();
			s1.close();
		} catch(Exception ie) {
			ie.printStackTrace();
		}
	}

}

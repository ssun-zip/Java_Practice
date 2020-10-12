package pra1012;

import java.io.*;
import java.net.*;
import java.util.*;

public class TimeClient {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner (System.in);
		System.out.println("타임 서버 IP");
		String ip = sc.nextLine();
		
		try {
			Socket ss = new Socket (ip, 7008);
			ObjectInputStream ois = new ObjectInputStream(ss.getInputStream());
			Date date = (Date) ois.readObject(); //날씨 객체 읽기
			System.out.println("현재 시간:" + date);
			ois.close();
			ss.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			sc.close();
		}
	}
}

//Connection refused: connect
// Java application tries to make a connection to the localhost 
// but to a port where no process is listening
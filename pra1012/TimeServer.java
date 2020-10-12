package pra1012;

import java.io.*;
import java.net.*;
import java.util.*;

public class TimeServer {

	public static void main(String[] args) {
		try {
			int port = 7008;
			ServerSocket ss = new ServerSocket(port);
			//소켓 생성
			// ServerSocket은 클라이언트-서버 소켓 연결에서 서버 측의 구현을 제공하는 클래스
			//ServerSocket은 포트에 연결할수 없으면 예외 발생
			System.out.println("서버 가동중...");
			while(true) {
				Socket client = ss.accept();
				//서버가 성공적으로 포트에 연결되면 serversocket객체는 생성되고
				//서버는 클라이언트로부터의 요청을 기다린다.
				//클리어언트ㅡ가 접속하야였을때 ss에다가 그 정보를 담습니다.
				//그런데 이건 호출되면 클라이언트가 접속할때까지 그 줄에서 기다립니다.
				//즉! 접속하지 전까지는 그 아래 명령문이 실핼 안된다.
				
				ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
				//출력스트림
				oos.writeObject(new Date()); //서버로 new Date()보낸다
				oos.flush(); // 버퍼의 내용을 즉시 보내라. 
				oos.close();
				client.close();
				
			}
		} catch (Exception e) { //예외 처리기
			System.out.println(e.getMessage()); //오류발생시 오류메시지를 얻어와라
		}
	}

}

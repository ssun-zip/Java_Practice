package Practice1008;

import java.io.*;
import java.net.*;
import java.util.*;

//서버는 주어진 서버 커넥션을 기다리며 받아드린다
public class DateServer {
	public static void main(String[] args) throws IOException{
		ServerSocket ss = new ServerSocket(9100);
		try {
			while(true) {
				//  9100 의 커넥션을 기다리며 받아드리기
				Socket socket = ss.accept();
				try {
					// character output stream
					PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
					out.println(new Date().toString());
				} finally {
					socket.close();
				}
			}
		} finally {
			ss.close();
		}
	}
}

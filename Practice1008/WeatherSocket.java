package Practice1008;

import java.io.*;
import java.net.*;


public class WeatherSocket {
	public static void main(String[] args) throws IOException{
		Socket s = new Socket("localhost", 9100);
		BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
		String res = input.readLine();
		System.out.println(res);
		System.exit(0);;
	}

}

/*
 public static void main1(String[] args) throws IOException{
		ServerSocket ss = new ServerSocket(9100);
		try {
			while(true) {
				Socket socket = ss.accept();
				try {
					PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
				} finally {
					socket.close();
				}
			}
		} finally {
			ss.close();
		}
	}
 
 */


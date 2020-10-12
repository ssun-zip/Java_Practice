package pra1012;

import java.io.*;
import java.net.*;

public class SimpleClient {

	public static void main(String[] args) {
		InputStream is;
		BufferedReader br;
		String message = null;
		try {
			Socket s1 = new Socket("127.0.0.1", 5432);
			is = s1.getInputStream();
			br = new BufferedReader(new InputStreamReader(is));
			message = br.readLine();
			System.out.println(message);
			s1.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
//java.net.SocketException: Connection reset

package Practice1008;

import java.io.*;
import java.net.*;


public class host2 {

	public static void main(String[] args) throws IOException {
		String hostname = "www.naver.com";
		try {
			InetAddress address = InetAddress.getByName(hostname);
			System.out.println("IP주소: " + address.getHostAddress());
		} catch (UnknownHostException e) {
			System.out.println(hostname + "의 IP주소를 찾을수없습니다");
		}
	}

}

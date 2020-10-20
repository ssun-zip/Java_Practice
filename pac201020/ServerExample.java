package pac201020;

import java.net.*;
public class ServerExample {
	public static void main(String[] args) {
		try{
			ServerSocket ss = new ServerSocket(9002);
		while(true){	
			// client로부터 정보를 받아들이기. 
			Socket client = ss.accept();
			PerClient pc  = new PerClient(client);
			pc.start();
		}	
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}
	}
}

//192.168.0.93
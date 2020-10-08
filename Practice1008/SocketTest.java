package Practice1008;

import java.io.*;
import java.net.Socket;
import java.util.*;
public class SocketTest {
	public static void main(String[] args) throws IOException{
		try(Socket s = new Socket("time-c.nist.gov", 13)){
			InputStream stream = s.getInputStream();
			Scanner in = new Scanner(stream);
			while(in.hasNextLine()) {
				String line = in.nextLine();
				System.out.println(line);
			}
		}
	}
}

package Practice1008;

import java.io.*;
import java.net.Socket;

// 클라이언트는 소켓을 받아드려 정보를 출력 
public class DateClient {
	public static void main(String[] args) throws IOException{
		Socket s = new Socket("localhost", 9100);
		// BufferReader = 문자열 inputstream으로 텍스트를 읽어 - 문자열 buffer 굴자,어레이, 라인의 효율을 위해
		BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
		String res = input.readLine();
		System.out.println(res);
		System.exit(0);;
	}
}

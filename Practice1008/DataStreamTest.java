package Practice1008;

import java.io.*;

public class DataStreamTest {

	public static void main(String[] args) throws IOException {
		DataInputStream in = null;
		DataOutputStream out = null;
		
		try {
			int c;
			out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("data.bin")));
			out.writeDouble(3.14);
			out.writeInt(100);
			
			out.writeUTF("자신의 셍각을 바꾸지 못하는 사람은 결코 현실을 바꿀수없다");
			
			//flush(): 버퍼를 수동으로 비우기, 남은것이 있다면 더 내보낸다
			//data.bin파일 생성할떄 dataoutputStream은 기존 바이트 스트림 객체의 킵퍼 클래스로만 생성
			// 먼저 버퍼된 파일을 출력 바이트 스트림을 생성하고 이것을 생성차이 매개변수로 전달 
			out.flush();
			
			in = new DataInputStream(new BufferedInputStream(new FileInputStream("data.bin")));
			
			System.out.println(in.readDouble());
			System.out.println(in.readInt());
			System.out.println(in.readUTF());

			
		} finally {
			if( in!= null) {
				in.close();
			}
			
			if( out != null) {
				out.close();
			}
		}
	}

}
/*
 * UTF-8 은 일반적으로 영문자를 하나의 바이트로 표현하는 가변 길이 문자 인코딩
 * 16비트 유니코드 문자들은 8비트 문자들로 변환하기 위한 방법
 * 유니코드 1바이트 -> 4 바이트까지 변경
 * 저통적인 아스키코드 1바이트로 표시할수 있다는 장점
 */
 

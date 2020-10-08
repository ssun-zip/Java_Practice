package Practice1008;

import java.io.*;
import java.util.*;

public class ByteStreamsLab {

	public static void main(String[] args) throws IOException{
			Scanner scan = new Scanner(System.in);
			System.out.print("원본 파일 이름을 입력하시오: ");
			String inputFileName = scan.next();
			System.out.print("복사 파일 이름을 입력하시오: ");
			String outputFileName = scan.next();
			
			//try블록안에서 스트림을 선언하고 초기화 하면 이것들을 닫을 필요가 없다 
			try(InputStream inputStream = new FileInputStream(inputFileName);
				OutputStream outputStream = new FileOutputStream(outputFileName)) {
					int c;
					while (( c = inputStream.read()) != -1) {
						outputStream.write(c);;
					}
				
			}
			System.out.println(inputFileName + "를 " + outputFileName + "로 복사하였습니다");
			
	}

}

package Practice1008;

import java.io.*;
import java.util.*;

public class FileReaderTest1 {

	public static void main(String[] args) throws Exception{
		Scanner stdin = new Scanner (System.in);
		System.out.println("읽어드릴 파일명을 입력하세요: ");
		String s = stdin.next();
		FileReader fr= new FileReader(s); //읽어드릴 파일명으로 객체 생성
		
		int i;
		
		while((i = fr.read()) != -1) {
			System.out.print((char) i);
		}
		
		fr.close();
	}

}

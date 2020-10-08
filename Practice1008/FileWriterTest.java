package Practice1008;
import java.io.*;
import java.util.*;

import java.util.Scanner;

//클래스의 이름과 FileWriter (오브젝트 타입)이 같으면 실행되지않는다

public class FileWriterTest {
	public static void main(String[] args) throws Exception { //exception이용하여 예외처리
		Scanner stdin = new Scanner(System.in);
		//파일 저장 문자열 생성
		String source = " 비어 있어야 비로소 가득해지는 사랑 \n" + 
							"영워히 사랑한다는 것은 \n" +
							"편온한 마음으로 아침을 맞는다는 것입니다. \n";
		
		char input[] = new char[source.length()];
		source.getChars(0, source.length(), input, 0);
		System.out.print("파일명을 입력하세요 : ");
		String s = stdin.next();
		FileWriter fw = new FileWriter(s);
		fw.write(input);
		fw.close(); 
		System.out.print( s + "파일명이 생성되었습니다");
	}
}

package Practice1008;

import java.io.*;
import java.util.Scanner;

// console에다가 text파일에 적고 싶은것을 적으면 
// 적혀진것이 해당 txt 파일에 그대로 옮겨지는 프로그램
public class FileWriterEx {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		FileWriter f = null;
		int c;
		try {
			// string에 들어가 있는 파일에다가 적기 
			f = new FileWriter("c:\\Temp\\test.txt");
			while(true) {
				// console 에다가 text에 적고 싶은거 적기
				String line = scanner.nextLine();
				// enter 누르면 
				// 래당 라인에 아무것도 적지않으면 loop종료 
				if(line.length() == 0) {
					break;
				}
				// line에  저장되있던것을  text file에다가 적용
				f.write(line, 0, line.length());
				// 줄바꾸고 다음문장으로 명령어
				// \r : 커서를 그 줄의 맨 앞으로 이동시킴 --> 그줄 맨앞으로 이동 (줄 바꿈)
				// \n :  처음으로 줄바꿈 함 --> 줄바꿈
				// \r\n : 줄바꿈 
				// 문자열의 0번째부터 2개의 문자를 출력
				// 3으로 하면 index out of bound range
				// (\r , \n ) -> 2개 or 1개로도 
				// Windows에서 문자 '\ n'을 쓰면 실제로 두 문자 시퀀스 '\ r \ n'이 출력됩니다
				f.write("\r\n", 0, 2);
			}
			f.close();
		} catch (IOException e) {
			System.out.println("입출력 번호");
		}
		scanner.close();
	}

}

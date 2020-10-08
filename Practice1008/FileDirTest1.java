package Practice1008;
import java.io.*;
public class FileDirTest1 {

	public static void main(String[] args) {
		String d = "c://Windows";
		// c://Window 디렉터리로 file 객체 생성
		File f1 = new File(d);
		if(f1.isDirectory()) {
			System.out.println("검색 디렉터리 " + d);
			System.out.println("=====================");
			String s[] = f1.list(); // 디렉터리의 모든요소를 문자배열로 생성 
			
			for(int i = 0; i < s.length; i++) {
				File f = new File(d + "/" + s[i]);
				// 디렌터리인지 파일인지 판별하여 출력
				if(f.isDirectory()) {
					System.out.println(s[i] + ": 디렉터리 ");
				} else {
					System.out.println(s[i] + ": 파일 ");
				}
						
			}

		} else {
			System.out.println("지정한" + d + "는 디렉터리가 아님");
		}
	}

}

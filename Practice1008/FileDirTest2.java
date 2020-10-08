package Practice1008;

import java.io.*;

public class FileDirTest2 {
	public static void main (String[] args) {
		File f1 = new File("c://Temp//input.txt ");
		
		System.out.println("파일 이름: " + f1.getName());
		System.out.println("파일 경로: " + f1.getPath());
		System.out.println("절대 경로: " + f1.getAbsolutePath());
		System.out.println(f1.exists() ? "파일존재" : "파일 없음");
		System.out.println(f1.canWrite() ? "수정가능" : "수정 불가능");
		System.out.println(f1.canRead() ? "읽기 가능" : "읽기 불가능");
		System.out.println(f1.isDirectory() ? "디렉토리" : "디렉토리 아님");
		System.out.println(f1.isFile() ? "파일" : "파일아님");
		System.out.println(f1.isAbsolute() ? "절대경로" : "상대경로");
		System.out.println("1970년 1월 1일부터 파일이 마지막 수정된 날짜까지의 밀리초 " + f1.lastModified());
		System.out.println("파일 크기: " + f1.length() + "Bytes");
	}
}

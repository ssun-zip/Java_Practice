package Practice1008;

import java.io.*;

public class FileTest {

	public static void main(String[] args) throws IOException{
		String name = "C:\\Users\\오전반\\eclipse-workspace\\Sep_28\\src";
		//파일 경로 설정 -> "C://User//505-015//Desktop//eclipse-java-neon-R-win32-x86_64//eclipse";
		File dir = new File(name);
		String[] fileNames = dir.list();
		
		for(String s : fileNames) {
			//절대경로로 이름을 주어야함
			File f = new File(name + "/" + s);
			
			System.out.println("===============================");
			System.out.println( "이름: " + f.getName());
			System.out.println( "경로: " + f.getPath());
			System.out.println( "부모: " + f.getParent());
			System.out.println( "절대경로: " + f.getAbsolutePath());
			System.out.println( "정규경로: " + f.getCanonicalPath());
			System.out.println( "디렉토리 여부: " + f.isDirectory());
			System.out.println( "파일여부: " + f.isFile());
			System.out.println("===============================");

		}
	}

}

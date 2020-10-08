package Practice1008;

import java.io.*;
import java.net.*;


public class WebImageDownload {

	public static void main(String[] args) throws IOException{
		String website = "http://www.oracle.com/us/hp07-bg121314-openworld-2x-2280475.jpg";
		System.out.println("" + website + "사이트에서 이미지를 다운로드 합니다.");
		URL url = new URL(website);
		byte[] buffer = new byte[2048];
		try(InputStream in = url.openStream(); FileOutputStream out = new FileOutputStream("test.jpg");) {
			int length = 0;
			while ((length = in.read(buffer)) != -1) {
				System.out.println("" + length + "바이트크기만큼 읽었음!");
				out.write(buffer, 0, length);
			}
			in.close();
			out.close();
		} catch (Exception e) {
			System.out.println("예의: " + e.getMessage());
		}
	}
}

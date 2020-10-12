package pra1012;

import java.io.*;
import java.net.*;

public class ServerExample {

	public static void main(String[] args) {
		ServerSocket ss = null;
		try {
			ss = new ServerSocket();
			ss.bind(new InetSocketAddress("192.168.0.93", 5001));
			//IP�� ��Ʈ��ȣ�� �������� ���� ���������� ������ȣ�� Ŭ���̾�Ʈ���� ���� �ȴ�.
			while(true) {
				System.out.println("[���� ��ٸ�]");
				Socket socket = ss.accept();
				InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
				//���� ������ client�� ����Ȯ��
				System.out.println("[���� ������]" + isa.getHostName()); //Ŭ���̾�Ʈ �ּ�Ȯ��
			}
		} catch (Exception e) {}
		
		if(!ss.isClosed()) {
			try {
				ss.close();
			} catch (IOException el) {}
			}
		}

}

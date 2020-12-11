package sec1.ex05;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

@WebListener
public class LoginImpl_a implements HttpSessionBindingListener{
	String user_id;
	String user_pw;
	static int total_user = 0;
	
	public LoginImpl_a() {
		
	}
	
	public LoginImpl_a(String user_id, String user_pw) {
		this.user_id = user_id;
		this.user_pw = user_pw;
	}
	
	// 세션에 저장시 접속사 수 증가. 
	public void valueBound (HttpSessionBindingEvent arg0) {
		System.out.println("세션 생성");
		++total_user;
	}
	
	// 세션 소멸시 접속사 수 감소 
	public void valueUnbound(HttpSessionBindingEvent arg0) {
		System.out.println("세션 소멸 ");
		--total_user;
	}
	
}


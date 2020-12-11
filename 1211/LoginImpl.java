package sec1.ex05;


import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

// 세션 바인딩 이벤트를 처리하는 이벤트 핸들러가 구현.
// 세션 바인딩 시 valueBound()가호출되어 static인 total_user값 증가 
// 세션 소멸시 접속자수를 감소
@WebListener
public class LoginImpl implements HttpSessionBindingListener{
	String user_id;
	String user_pw;
	static int total_user = 0;
	
	public LoginImpl() {
		
	}
	
	public LoginImpl(String user_id, String user_pw) {
		this.user_id = user_id;
		this.user_pw = user_pw;
	}
	
	// 세션에 저장시 접속사 수 증가. 
	public void valueBound (HttpSessionBindingEvent arg0) {
		System.out.println("사용자 접속");
		++total_user;
	}
	
	// 세션 소멸시 접속사 수 감소 
	public void valueUnbound(HttpSessionBindingEvent arg0) {
		System.out.println("사용자 접속 해제 ");
		total_user--;
	}
	
}

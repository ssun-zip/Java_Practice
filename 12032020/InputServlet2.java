package httpserv01;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/input3")
public class InputServlet2 extends HttpServlet{
	public void init() throws ServletException{
		System.out.println("init method called");
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");

		// 열거타입 : 미리 정해진 일정한 값을 가지고 새로운 자료형을 사용자가 직접 만드는것 
		// 특징 : 하나의 클래스로 인식, 객체 생성 불가, 문자열로 정의되어있지만 정수 취급 
		// action of mentioning a number of things one by one
		// specify the input streams
		// Enumeration enum 이라고는 사용하지
		// enum 이 jdk1.5 이상부터는 예약어가 되어서 에러가
		Enumeration enumAa =request.getParameterNames();
		while (enumAa.hasMoreElements()) {
			String name = (String)enumAa.nextElement();
			String[] values = request.getParameterValues(name);
			for(String value:values) {
				System.out.println("name=" + name + ", values =" +value);
			}
			// 열거타입인 enumA의 데이터를 하나하나씩 추출해내기 위해서 for loop으로 돌려
			// input name 과 각각 values라는 나열에서 하나의 value만을 추출하여
			// 쌍이되도록 name - value 를 만들어준다. 
		}
	}
	
	public void destroy() {
		System.out.println("destroy method called");
	}
}

/*
servlet 응답처리 방법
doGet() or doPost() 메서드안에서 처리함 
javax.servlet.http.HttpServletResponse 객체를 이용함
setContentType() 을 이용해 클라이언트에게 전송할 데이터 종류(Mime-type) 을 지정하여
클라이언트(웹 브라우저)와 서블릿의 통신은 자바 IO의 스트림을 이용함.

<Mime-type>
:톰캣 컨테이너에 미리 정해놓은 데이터 종류로 서블릿에서 브라우저 전송시 설정
ex.
HTML 전송시 :text/html
일반 텍스트로 전송시 :text/plain
xml 데이터 전송시 : application/xml

HttpServletResponse를 이용한 서블릿 응답 실습 대략적인 순서
1. setContentType(를 이용해 mime-type지정
2. 데이터를 출력할 PrintWriter객체 생성
3. 출력할 데이터를 HTML형식으로 만듬
4. PrintWriter의 print() 나 println()을 이용해 데이터 출력한다.
5. 
*/
package httpserv01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	/*
	 * 클래스를 구분하기 위한 값으로 사람에게 주민번호와 같은 역할 
	 * 객체의 직렬화와 같이 객체에 저장된 데이터를 입출력 할 때
	 * JVM 같은 클래스 이름과 버전 ID 가진 객체를 출력합니다.
	 * 클래스는 명시적으로 serialVersionUID 필드를 정의해 클래스 버전에 따른
	 * 고유번호를 포함하기 때문이다. 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//클라이언트에게 응답할 페이지 정보를 세팅한다
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// ctrl + shift + O : 자동 import
		out.print("<html><body><h1>");
		out.print("Hello Servlet");
		out.print("</h1></body></html>");
		out.close();
		
	}
}
/*
URL Mapping 이란 서블릿을 동작시키기 위해서 실제 자바 클래스 명을 사용하는 대신
서블릿을 요청하기 위한 문자열을 말합니다.
[URL mappings: ] 목록에서 항목을 선택 한 후 edit 버튼을 클릭합니다.
[URL mappings] 창이 나타나면 [Patterns: ]
입력란에 패천명(/hello) 을 입력한 후에 ok 버튼을 클릭홥니다.
서블렛을 요청하기 위한 URL에서 http://localhost 은 웹 서버에 접속하기 위한
ip 주소이고 8181 톰캣을 설치하면서 지정한 포트 번호입니다. 
그렇기 때문에 http://localhost:8181은 톰켓 서버에 접속하겠다는 의미입니다. 

http:localhost:8181 까지 입력하면 웹 서버까지 접근했다면 어떤 서비스를 받을지에 따
그 이후에 기술되는 내용이 달라지는데 이후에 기술하는 문자열을 컨텍스트 패스라고 하고
이에 의해서 요청되는 웹 애플리케이션이 달라집니다. 

컨텍스트 패스 context path 란 개념을 다시 정리하면 웹 서버에서 제공하는
다양한 웹 애플리케이션을 구분하기 위해서 사용하는 것 
*/
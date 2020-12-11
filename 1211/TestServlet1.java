package sec1.ex05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 이름이 정확히 일치하는 uri 패턴 
//first/test요청할 때 실행
// 브라우저의 요청 URL에 대해 서블릿의 여러가지 메서드를 이하여 요청 관련 정보를 가져옵니다. 
//@WebServlet("/first/test")
public class TestServlet1 extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// context 이름만 가져옵니다. 
		String context = request.getContextPath();
		// 전체 url 가져옵니다. 
		String url = request.getRequestURI().toString();
		// 서블릿 매핑 이름을 가져옵니다. 
		String mapping = request.getServletPath();
		// uri를 가져옵니다. 
		String uri = request.getRequestURI();
		
		out.print("<html>");
		out.print("<head>");
		out.print("<title> Test Servlet1 </title>");
		out.print("</head>");
		out.print("<body bgcolor = 'green'>");
		out.print("<b> 컨텍스트명 :" + context + "</b><br>");
		out.print("<b> 전체경로 명 :" + url + "</b><br>");
		out.print("<b> 매핑명  :" + mapping + "</b><br>");
		out.print("<b> URI  :" + uri + "</b><br>");
		out.print("</body>");
		out.print("</html>");
		out.close();
	}
}

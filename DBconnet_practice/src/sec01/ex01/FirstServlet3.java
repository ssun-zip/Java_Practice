package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/first3")
public class FirstServlet3 extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<script type = 'text/javascript'>");
		out.print("location.href = 'second3';");
		out.print("</script>");
	}
	// 자바 스크립트 location 객체의 href 속성을 이용 
	// 자바스크립트에서 재요청하는 방식
	// 형식 : location.href= '요청할 서블릿 또는 JSP ';
}

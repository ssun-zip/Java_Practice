package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/first")
public class FirstServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//sendRedirect는 브라우저측에서 지정받은 요청 경로로 다시 재요청
		// 메서드를 이용한 지정한 경로로 제어를 이동
		// client 갔다가 second servlet 으로 요청
		response.sendRedirect("second"); //다른 서블릿으로 second 로 재요청한다. 
	}
}

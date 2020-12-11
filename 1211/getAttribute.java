package sec1.ex05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet("/get")
public class getAttribute extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// 객체 생성 
		ServletContext ctx = getServletContext(); // 전역 스프 (애플리케이션 전체)
		HttpSession sess = request.getSession(); // 브라우저 스코프 (브라우저에서만) 
		
		String ctxMessg = (String) ctx.getAttribute("context");
		String sesMessg = (String) sess.getAttribute("session");
		String reqMessg = (String) request.getAttribute("request"); // setAttribute 요청-응답 사이클 
		
		out.print("context값: " + ctxMessg + "<br>");
		out.print("session 값: " + sesMessg + "<br>");
		out.print("request 값: " + reqMessg + "<br>");
	}
}
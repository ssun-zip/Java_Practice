package httpserv01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class loginServer extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public loginServer() {
		super();
	}
	/*
	 * public void init() throws ServletException {
	 * 	    System.out.println("init 메소드 호출");
	 * }
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
		 response.setContentType("text/html; charset=UTF-8");
		 String user_id = request.getParameter("user_id"); // request에서 화면으로 부터 넘어온 파라메터의 값을 추출 합니다.
		 String user_pw = request.getParameter("user_pw"); // request에서 화면으로 부터 넘어온 파라메터의 값을 추출 합니다.
		PrintWriter out = response.getWriter();
		out.println("<h3> 로그인이되었습니다. </h3>");
		out.println("아이디 :" + user_id + "<br>");
		out.println("비밀번호 :" + user_pw);
		out.close();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
	}
	
	public void destory() {
		System.out.println("destroy 메소드 호출 ");
	}
}

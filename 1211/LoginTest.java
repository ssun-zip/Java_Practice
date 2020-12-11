package sec1.ex05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/login1")
public class LoginTest extends HttpServlet{
		private static final long serialVersionUID = 1L;
			
		protected void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
			//request.setCahracterEncodiing("utf-8");
			// post 방식으로 한글 저송시 인코딩을 생략한다. 
			// 한글 인코딩 처리를 통해 필터 기능 실습. 
			
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			
			String user_name = request.getParameter("user_id");
			String user_pwd = request.getParameter("user_pw");
		
			out.print("<html><body>");
	        out.print("아이디: " + user_name+"<br>");
	        out.print("비밀번호: " + user_pwd+"<br>");
	        out.print("</body></html>");
		}
}

package httpserv01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login4")
public class loginServlet3 extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public void init() throws ServletException {
			System.out.println("init method called");
	}
		
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String id= request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		
		String data = "<html>";
		data += "<body>";
		data += "아이디 : " + id;
		data += "<br>";
		data += "비밀번호: " + pw;
		data += "</html>";
		data += "</body>";
		out.print(data);
	}
	
	public void destroy() {
		System.out.println("destroy method 호출 ");
	}
}

package httpserv01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logintest2")
public class LoginTest2 extends HttpServlet{
	public void init() {
		System.out.println("init method called");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws IOException, ServletException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String id= request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		
		System.out.println("아이디: " + id);
		System.out.println("password: " + pw);
		
		if(id != null && (id.length()!= 0)) {
			if(id.equals("admin")) {
				out.print("<html>");
				out.print("<body>");
				out.print("<font size = '12'> 관리자로 로그인 하셨습니다. !!!! </font>");
				out.print("<br>");
				out.print("<input type = button value = '회원정보 수정하기' >");
				out.print("<input type = button value = '회원정보 삭제하기' >");
				out.print("</body>");
				out.print("</html>");
			} else {
				out.print("<html>");
				out.print("<body>");
				out.print(id + " 님!!!!! 로그인 하셨습니다 . ");
				out.print("</body>");
				out.print("</html>");			
			}
		} else {
			out.print("<html>");
			out.print("<body>");
			out.print(" ID 와 비밀번호를 입력하세요 !!! ");
			out.print("<br>");
			out.print( " <a href = 'http://localhost:8080/1203/login2.html'> login return </a>");
			out.print("</body>");
			out.print("</html>");				
		}
	}
}

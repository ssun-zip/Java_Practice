package sec1.ex04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session5")
public class SessionTest5 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}	

	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		if(session.isNew()) { // 최초접속 시
			if(user_id != null) {
				session.setAttribute("user_id", user_id);
				String url = response.encodeURL("login");
				// url 변수에 encoderURL()을 이용하여 응답시 미리 jsessionID를 저장한다. 
				out.println("<a href=" + url + ">로그인 상태 확인</a>");
			}else {
				out.println("<a href='login2.html'> 다시 로그인 하세요!! </a>");
				// 로그인 상태 확인시 isessionid를 서블릿으로 다시 전한다. 
				session.invalidate();
			}
		}else {
			user_id = (String) session.getAttribute("user_id");
			if(user_id != null && user_id.length() != 0) {
				out.print("안녕하세요 " + user_id + "님!!!");
			} else {
				out.print("<a href='login2.html'> 다시 로그인 하세요!! </a>");
				session.invalidate();
			}
		}		
	}
}
//서블릿에 jsessionId 쿠키 값을 전송해 로그인 상태를 유지합니다.
// http://localhost:8080/login;jsessionid=13099AB19....
package sec1.ex05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * LoginImpl을 실행하여 전송된 ID와 비밀번호를 저장한다. 
 * setAttribute(loginuser, loginuser)으로 세션에 바인딩 시 미리 HttpSessionbindingListener
 * 구현한 LoginImpl의 valueBound 메서드를 호출 
 */
//@WebServlet("/login5")
public class LoginTest_a extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String user_id = request.getParameter("user_id");
		String user_pwd = request.getParameter("user_pw");
	
		// 	이벤트 핸들러를 생성한 후 세션에 저장합니다. 
		LoginImpl loginUser = new LoginImpl(user_id, user_pwd);
		if(session.isNew()) {
			session.setAttribute("loginUser", loginUser);
			// session 바인딩 시 LoginImpl의 valueBound메소드를 호출한다 
		}
		out.println("<head>");
		out.println("<script type = 'text/javascript'>");
		// 5초마다 서블릿에 재요청하 현재 접속사수 표시 
		out.println("setTimeout('hyistory.go(0);', 5000)");
		out.println("</script>");
		out.println("</head>");
		out.println("<html><body>");
		// 접속자수를 브라우저로 출력합니다. 
		out.println("아이디는 " + loginUser.user_id + "<br>");
		out.println("총 점속자 수는 " + LoginImpl.total_user + "<br>");
		out.println("</body></html>");
	}
}

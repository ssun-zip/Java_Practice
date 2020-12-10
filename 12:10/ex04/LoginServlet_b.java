 package sec1.ex04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/loginservletb")
public class LoginServlet_b extends HttpServlet{
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException {
		doHandle(request, response);
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException {
		doHandle(request, response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String user_id = request.getParameter("user_id");
		String user_pwd = request.getParameter("user_pwd");
		
		MemberVO_b memberVO = new MemberVO_b();
		memberVO.setId(user_id);
		memberVO.setPwd(user_pwd);
		MemberDAO_b dao = new MemberDAO_b();
		
		boolean result = dao.isExisted(memberVO);
		
		if(result) {
			HttpSession session = request.getSession();
			session.setAttribute("isLogon", true);
			session.setAttribute("login.id", user_id);
			session.setAttribute("login.pwd", user_pwd);

			out.print("<html><body>");
			out.print("안녕하세요 " + user_id + "님!!!<br>");
			out.print("<a href='show'>회원정보보기</a>");
			out.print("</body></html>");			
			
		}else {
			out.print("<html><body>회원 아이디가 틀립니다.");
			out.print("<a href='login3.html'> 다시 로그인하기</a>");
			out.print("</body></html>");			
		}
	}
}

/*
 * 톰캣을 재실행한 후 로그인창을 거치지않고 바로 /show 로 요청한 경우
 * 로그인을 하지 않았으므로 다시 로그인창으로 리다이렉트 됩니다.
 */

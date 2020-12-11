package sec1.ex05;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * setAttribute통해 로그인유저를 세션에 바인딩하여 이벤트 핸들러를 통해 접속사 수 증가
 * user_list에 접속자 ID를 저장한 다음 ServletContext객체에 바인딩. 
 */
@WebServlet("/login_b")
public class LoginTest_b extends HttpServlet{
		private static final long serialVersionUID = 1L;
		ServletContext context = null;
		// 로그인한 접속자 ID를 저장하는 ArrayList
		List user_list = new ArrayList();
			
		protected void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			context = getServletContext();
			PrintWriter out = response.getWriter();
			HttpSession session = request.getSession();
			String user_id = request.getParameter("user_id");
			String user_pwd = request.getParameter("user_pw");
		
			// 	이벤트 핸들러를 생성한 후 세션에 저장합니다. 
			// 객체 생성후 ID와 비밀번호 전송 
			LoginImpl_a loginUser = new LoginImpl_a(user_id, user_pwd);
			// 최초 로그인시 접속자 ID를 ArrayList에 차례대로 저장한 후 다시 
// context 객체에 속성으로 저
			if(session.isNew()) {
				session.setAttribute("loginUser", loginUser);
				user_list.add(user_id);
				context.setAttribute("user_list", user_list);
			}
			out.println("<html><body>");
			// 접속자수를 브라우저로 출력합니다. 
			out.println("아이디는 " + loginUser.user_id + "<br>");
			// 세션에 반인딩 이벤트 처리 후 총 접속자 수 표시 
			out.println("총 점속자 수는 " + LoginImpl_a.total_user + "<br>");
			out.println("접속 아이디: <br>");
			// context 객체의 arrayList를 가져와 접속자 ID 를 차례로 브라우저로 출력합니다. 
			List list = (ArrayList) context.getAttribute("user_list");
			for(int i = 0; i < list.size(); i++) {
				out.println(list.get(i)+ "<br>");
			}
			//로그아웃 클릭 시 서블릿 로그아웃으로 접속 ID를 전송해 로그아웃 완료 
			out.print("<a href = 'logout?user_id=" + user_id + "'> 로그아웃 </a>");
			out.println("</body></html>");
			
		}
}


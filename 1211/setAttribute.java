package sec1.ex05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet("/set")
public class setAttribute extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// 바인딩 result 확인을 위한 text 출력 
		String ctxMessage = "context에 바인딩 됩니다.";
		String sesMessage = "session에 바인딩 됩니다.";
		String reqMessage = "request에 바인딩 됩니다.";
		
		// 전역 스코프 - 속성은 애플리케이션 전체에서 접근할 수 있다. 
		ServletContext ctxContext = getServletContext();
		// 브라우저 스코프 - 속성은 브라우저에서만 접근할수 있다. 
		HttpSession session = request.getSession();
		ctxContext.setAttribute("context", ctxMessage);
		session.setAttribute("session", sesMessage);
		// 리퀘스트 스코프 - 속성은 해당 요청-응답 사이클 안에서만 접근할 수 있다. 
		request.setAttribute("request", reqMessage);
		out.print("바인딩을 수행합니다. ");
		
		/* 이코드를 실행하게 되면 request session에대한 정보도 함께 넘어간다. 
		RequestDispatcher dis = request.getRequestDispatcher("/get");
		dis.forward(request, response);
		*/
	}
}

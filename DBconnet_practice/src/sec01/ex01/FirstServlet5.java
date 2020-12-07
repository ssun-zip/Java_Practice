package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/first5")
// 브라우저에 전달된 request에 주소를 바인딩 한 후 dispatch 방법을 통해 다른 서블릿으로 포워딩 
public class FirstServlet5 extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// 웹 브라우저 최초 요청 request에 바인딩 
		request.setAttribute("address",  "서울시 서대문구 북과좌2동");
		// 바인딩된 request를 다시 두번째 서블릿으로 포워드 합니다. 
		RequestDispatcher dispatch = request.getRequestDispatcher("second5");
		dispatch.forward(request, response);
		// 두문장이 dispatch방식을 사용해 second5 Servlet 으로 전달된다. 
	}
}
/*
HttpServletRequest를 이용한 redirect/refresh/location 포워딩 시 바인딩
: 처음 웹 브라우저에서 서블릿으로 요청하면, 서블릿에서 웹 브라우저에 재 요청할 정보를 주고, 웹 브라우저에서 재 요청
 - 즉 첫 번째 요청과 두 번째 요청이 각기 별개의 요청(다른 요청)/ 서블릿에서 바인딩한 데이터를 다른 서블릿으로 전송할 수 없음
 
HttpServletRequest를 이용한 dispatch 포워딩 시 바인딩
: 첫번째 서블릿에서 두 번째 서블릿으로 전달되는 request가 브라우저를 거치지 않고 바로 전달 -바인딩된 데이터가 그대로 전달
 -  dispatch 방식으로 바인딩된 데이터를 서블릿이나 JSP로 전달
*/
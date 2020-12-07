package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/first2")
public class FirstServlet2 extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		response.addHeader("Refresh", "1;url=second2"); 
		// refresh을 이용한 포워딩 역시 redirect 처럼 웹 브라우저를 거쳐서 요청을 수행 
		// 클라이언트의 웹 브라우저에서 첫번째 서블릿에 요청 첫 번째 서블릿은 addHeader() 메서드를
		// 이용해 두번째 서블릿을 웹 브라우저를 통해서 요청
		// 웹 브라우저는 addHeader() method 가 지정한 두번째 서블릿을 다시 요청 
		// AddHeader (string name, string value)
		//  name = name of the HTTP header to add value to.
		//  value = string to add to the header.
	}
}

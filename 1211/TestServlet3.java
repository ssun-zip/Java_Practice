package sec1.ex05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 매핑이름에 상관없이확장자가 .do or * 이면 실행 
//@WebServlet("*.do") // 확장자만 일치하는 패턴 
// @WebServlet("/*")   // 모든 요청 URL 패턴 

// 확장자가 일치했을 경우 출력 결과 예시
/*
 * 	/base.do  or  /second/base.do 로 요청 
 *  /first/base.do 일 경우 요청하면 확장자명이 .do로 끝나지만 앞의 디렉터리
 *  이름이 우선하므로 TestServlet2 가 실행됩니다. 
 *  반면 /second/base.do일 경우 /second 디렉터리가 존재하지 않으므로 확장자명 .do 우성하여
 *  TestServlet3가 실행됩니다. 
 */
public class TestServlet3 extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// context 이름만 가져옵니다. 
		String context = request.getContextPath();
		// 전체 url 가져옵니다. 
		String url = request.getRequestURI().toString();
		// 서블릿 매핑 이름을 가져옵니다. 
		String mapping = request.getServletPath();
		// uri를 가져옵니다. 
		String uri = request.getRequestURI();
		
		out.print("<html>");
		out.print("<head>");
		out.print("<title> Test Servlet3 </title>");
		out.print("</head>");
		out.print("<body bgcolor = 'red'>");
		out.print("<b> TestServlet3 입니다. </b><br>");
		out.print("<b> 컨텍스트명 :" + context + "</b><br>");
		out.print("<b> 전체경로 명 :" + url + "</b><br>");
		out.print("<b> 매핑명  :" + mapping + "</b><br>");
		out.print("<b> URI  :" + uri + "</b><br>");
		out.print("</body>");
		out.print("</html>");
		out.close();
	}
}

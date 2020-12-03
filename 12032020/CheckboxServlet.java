package httpserv01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CheckboxServlet")
// httpServlet 안적을 시에 405 error 
public class CheckboxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CheckboxServlet() {
        super();     
    }
    
    // 전송할때 URL 뒤에 name=value 형태로 전송
   // 디폴트 전송 방식이며, 보안에 취약하다 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		String items[] = request.getParameterValues("item");
		// checke된 아이템이 없는 경우 
		if (items == null) {
		out.print("선택한 항목이 없습니다.");
		} else {
		out.println("당신이 선택한 항목입니다.<hr>");
		// array 로 되어있는 items에서 하나의 item value 값을 받아온다. 
		for (String item : items) {
		out.print(item + " ");
		}
		}
		// 전페이지로 가는 js history.go()
		out.println("<br><a href='javascript:history.go(-1)'>다시</a>");
		out.print("</body></html>");
		out.close();
	}
	
	// TCP/IP protocol의 head영역에 숨겨진 채 전송
	// 데이터 무제한, GET 방식보다 느리지만 보안에 유리하다 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

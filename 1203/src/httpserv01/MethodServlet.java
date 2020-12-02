package httpserv01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/method")
public class MethodServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public MethodServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
		 response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		out.println("<h1> get이 호출되었습니다. </h1>");
		out.print("</body></html>");
		out.close();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		 response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<h1> post이 호출되었습니다. </h1>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}

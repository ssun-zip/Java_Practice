package httpserv01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addition")
public class AdditionalServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public AdditionalServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		int num1 = 20;
		int num2 = 20;
		int add = num1 + num2;
		out.println("<html><head><title>Addition</title></head>");
		out.println("<body>");
		out.println(num1 + " + " + num2 + " = " + add);
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
	}

}

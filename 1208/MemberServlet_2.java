package sec01.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/member2")
public class MemberServlet_2 extends HttpServlet{
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
		MemberDAO_2 dao = new MemberDAO_2();
		PrintWriter out = response.getWriter();
		String command = request.getParameter("command");
		if(command != null && command.equals("addMember")){
			String _id = request.getParameter("id");
			String _pwd = request.getParameter("pwd");
			String _name = request.getParameter("name");
			String _email = request.getParameter("email");
		
			MemberVO_2 vo = new MemberVO_2();
			vo.setId(_id);
			vo.setPwd(_pwd);
			vo.setName(_name);
			vo.setEmail(_email);
			dao.addMember(vo);
		} else if (command!=null && command.equals("delMember")) {
			String id = request.getParameter("id");
			dao.delMember(id);
		}
		List list = dao.listMembers();
		out.print("<html><body>");
	    out.print("<table  border=1><tr align='center' bgcolor='lightgreen'>");
	    out.print("<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>가입일</td></tr>");
	    
	     for (int i=0; i<list.size();i++){
	    	MemberVO_2 memberVO=(MemberVO_2) list.get(i);
	 		String id=memberVO.getId();
	 		String pwd = memberVO.getPwd();
	 		String name=memberVO.getName();
	 		String email=memberVO.getEmail();
	 		Date joinDate = memberVO.getJoinDate();
	 		out.print("<tr><td>"+id+"</td><td>"+
	 			                pwd+"</td><td>"+
	 			                name+"</td><td>"+
	 			                email+"</td><td>"+
	 			                joinDate+"</td><td>" +
	 			                //delMember(String id)
	 			                // 링크를 이용해 삭제를 누르게 되면 해당 id의 id를 보내 delete한다. 
	 			               "<a href='member2?command=delMember&id=" + id + "'> 삭제 </a></td></tr>");		
	       }
	       out.print("</table></body></html>");
	       // 다시 member form 페이지로 보내져 새로운 회원을 등록할 수 있도록 설정해 준다. 
	       out.print("<a href = 'memberForm.html'> 새 회원 등록하기 </a>");
	}
}

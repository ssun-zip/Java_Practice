package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 회원 조회와 관련된 자바 클래스 파일인 MemberDAO, MemberServlet, MemberVO 클래스가 들어갈 것)

@WebServlet("/member")
public class MemberServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
                                                    throws ServletException, IOException {
      response.setContentType("text/html;charset=utf-8");
      PrintWriter out=response.getWriter();
      // SQL문으로 조회할 MemberDAO 객체 생성
      // 클래스명 + 객체변수명 = new 클래스명;
      // 객체 생성이라는 뜻은 / 기억장소에 객체의 요소를 저장할 공간이 배정
      MemberDAO dao=new MemberDAO();
      // MemberDAO.java - List<MemberVO>listMembers() 메서드로 회원 정보 조회 하여 정보를
      // 담긴 list 를 받아온다. 
      // List에 MemberVO 자료형 대입 명시 
      List<MemberVO> list=dao.listMembers();
	
      out.print("<html><body>");
      out.print("<table  border=1><tr align='center' bgcolor='lightgreen'>");
      out.print("<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>가입일</td></tr>");
     
      //arraylist에 담긴 회원수만큼 정보를 출력한다. 
     for (int i=0; i<list.size();i++){
    	// 조회한 회원 정보를 for과 <tr> 태그를 이용해 리스트로 출력
    	// MemberVO 클래스를 이용하여 각 데이터베이스에 담긴 정보를 빼온다. 
    	// MemberVO역할: 데이터베이스에 저장된 데이터를 저장하는역할의 클래스 
		MemberVO memberVO=(MemberVO) list.get(i);
		String id=memberVO.getId();
		String pwd = memberVO.getPwd();
		String name=memberVO.getName();
		String email=memberVO.getEmail();
		Date joinDate = memberVO.getJoinDate();
		out.print("<tr><td>"+id+"</td><td>"+
			                pwd+"</td><td>"+
			                name+"</td><td>"+
			                email+"</td><td>"+
			                joinDate+"</td></tr>");		
      }
      out.print("</table></body></html>");
   }
}

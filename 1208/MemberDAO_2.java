package sec01.ex02;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO_2 {
	private Connection con;
	   private PreparedStatement pstmt;
	   private DataSource dataFactory;

	   public MemberDAO_2() {
	      try{
	    	  // //1. JNDI 서버 객체 새성
	    	 Context ctx = new InitialContext();
	    	 //2. lookup()
	         Context envContext = (Context) ctx.lookup("java:/comp/env");
	         dataFactory = (DataSource) envContext.lookup("jdbc/oracle"); 

	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   }
	   
	   public List<MemberVO_2> listMembers() {
		   List<MemberVO_2> list = new ArrayList<MemberVO_2>();
		   try {
		         //connDB()- getConnection()
		         con = dataFactory.getConnection(); 
		         String query = "select * from t_menber";
		         System.out.println("prepareStatement: " + query);
		         pstmt = con.prepareStatement(query); 
		         ResultSet rs = pstmt.executeQuery(); 
		         
		         while (rs.next()) {
		            String id = rs.getString("id");
		            String pwd = rs.getString("pwd");
		            String name = rs.getString("name");
		            String email = rs.getString("email");
		            Date joinDate = rs.getDate("joinDate");
		            MemberVO_2 vo = new MemberVO_2(); 
		            vo.setId(id);
		            vo.setPwd(pwd);
		            vo.setName(name);
		            vo.setEmail(email);
		            vo.setJoinDate(joinDate);
		            list.add(vo); 
		         }
		         rs.close();
		         pstmt.close();
		         con.close();
		      } catch (Exception e)
		      {
		         e.printStackTrace();
		      }
		      return list;   
	   }
	   
	   //form에서 받은 정보를 데이터베이스에 넣어주는 역할  
	   public void addMember( MemberVO_2 memberVO) {
		   try {
			   con = dataFactory.getConnection();
			   String id = memberVO.getId();
			   String pwd = memberVO.getPwd();
			   String name = memberVO.getName();
			   String email = memberVO.getEmail();
			   String query = "insert into t_menber";
			   query += " (id,pwd,name,email)";
			   query += " values(?,?,?,?)";
			   // value (id, pwd, name, email) 순으로 저장 
			   System.out.println("prepareStatement: " + query);
			   pstmt = con.prepareStatement(query);
			   pstmt.setString(1,  id);
			   pstmt.setString(2, pwd);
			   pstmt.setString(3,  name);
			   pstmt.setString(4,  email);
			   pstmt.executeUpdate();
			   pstmt.close();   

		   } catch (Exception e) {
			   e.printStackTrace();
		   }
	   }
	   
	   // MemberServlet에서 삭제 요청이 들어오면 해당 id를 삭제하는 역할 
	   public void delMember(String id) {
		   try {
			   con = dataFactory.getConnection();
			   String query = "delete from t_menber" + " where id=?";
			   System.out.println("preparedStatement:" + query);
			   pstmt = con.prepareStatement(query);
			   pstmt.setString(1,  id);
			   pstmt.executeUpdate();
			   pstmt.close();
		   } catch (Exception e) {
			   e.printStackTrace();
		   }
	   }
}

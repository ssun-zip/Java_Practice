package sec01.ex02;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO_1{
   
   //private static final String driver = "oracle.jdbc.driver.OracleDriver";
   //private static final String url = "jdbc:oracle:thin:@localhost:1521:XE";
   //private static final String user = "scott";
   //private static final String pwd = "tiger";
   
   private Connection con;
   private PreparedStatement pstmt;
   private DataSource dataFactory;

   public MemberDAO_1() {
      try{
    	  // //1. JNDI 서버 객체 새성
    	 InitialContext ctx = new InitialContext();
    	 //2. lookup()
         Context envContext = (Context) ctx.lookup("java:/comp/env");
         dataFactory = (DataSource) envContext.lookup("jdbc/oracle"); 

         
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
   
   public List listMembers() {
      List list = new ArrayList();
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
            MemberVO_1 vo = new MemberVO_1(); 
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
   
}
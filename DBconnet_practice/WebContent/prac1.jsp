<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "java.sql.*, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 연결 확인 예제 </title>
</head>
<body>
	<% Connection conn = null;
		try {
			String host = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "scott";
			String password = "tigger";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// my db driver
			conn = DriverManager.getConnection(host, user, password);
			
			out.println("연결 성공!");
		} catch (ClassNotFoundException e) {
			out.println("연결 드라이버 없음"); //클래스가 없으면 설정 
		} catch (SQLException e) {
			out.println("연결실패" );
		}finally {
			if(conn != null){
				conn.close(); //conn 에 정보가 없을 경우에는 닫음. 
			}
		}
		
	%>
</body>
</html>
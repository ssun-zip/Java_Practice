package sec01.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

// 자바 코드 로직 부분 담당 
// 알고리즘 부분을 SQL 데이터베이스와 공유 
// : JDBC를 사용한 데이터베이스 연동을 하여 페이지에 필요한 정보를 데이터베이스에서 
// 가져오거나 페이지에서 저장한 정보를 데이터베이스에 넣는 역할을 한다. 
//Data Access Object : DB 연동하여 CRUD 작업을 하는 클래스

public class MemberDAO {
	private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String user = "scott";
	private static final String pwd = "tigger";
	private Connection con;
	private Statement stmt;

	public List<MemberVO> listMembers() {
		// 각 행보의 정보를 담는 배열로 담을 ArryaList 로 생성 
		List<MemberVO> list = new ArrayList<MemberVO>();
		try {
			connDB();
			String query = "select * from t_menber ";
			System.out.println(query);
			ResultSet rs = stmt.executeQuery(query);
			//회원에 대한 데이터가 존재하는 경우 sql 에서 받아와 array "list" 에 
			// 순서대로 저장한다. 
			while (rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				MemberVO vo = new MemberVO();
				// vo객체에 해당 정보들을 담기 
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);
				// 정보가 담긴 vo 객체를 arrayList 배열에 담기 
				list.add(vo);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	private void connDB() {
		try {
			// Driver는 oracle sql 에 접속하게 해주는 매개체 같은 역할 
			// 동적 로딩 방식 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Oracle 드라이버 로딩 성공");
			con = DriverManager.getConnection(url, user, pwd);
			// : DriverManager에 등록된 각 드라이버들을 사용해서 식별한다.
			System.out.println("Connection 생성 성공");
			stmt = con.createStatement();
			// : SQL 쿼리를 생성/ 실행하여, 반환된 결과를 가져오게 하는 작업 영역
			System.out.println("Statement 생성 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
/*
Prepared Statement interface 특징 :
PS 인페이스를 상속하므로 지금까지 사용한 메서드를 그대로 사용함. statement 인터페이스에 대해서
prepared statement 인터페이스는 컴파일된 sql 을 dbms에 전달하여 성능을 향상 시킴.
실행하려는sql 문에 ? 를 넣을 수 있으므로 ? 값만 바꾸어 손쉽게 설정할수 있어 statement보다 sql 작성 편리 
*/
package sec01.ex01;

import java.sql.Date;

// java bean
// JavaBean 이란 특정한 일을 독립적으로 수행하는 컴포넌트를 의미한다. Java 에서 쉽게 말해 “Class” 개념이다.
// Beans를 사용하게 되면 데이터 처리와 공용화된 기능을 제공하기 때문에 잘 
// 활용만 한다면 프로그램의 중복을 줄이고 더욱 원할하게 유지·보수를 할 수 있다.
// 멤버변수가 오고 데이터베이스와 연동하는 빈즈 데이터베이스 테이블의 컬럼 이름과 매칭된다.
// JSP 액션과 연동을 위해 getter setter 생성 

// jsP에서 빈즈 선언할때
// <jsp:useBean id="mybean" scope="request" class="MyBean" />

//VO : value object - 데이터베이스에 저장된 데이터를 저장하는역할의 클래스 

public class MemberVO {
	private String id;
	private String pwd;
	private String name;
	private String email;
	private Date joinDate;
	
	public MemberVO() {
		System.out.println("MemberVO 생성자 호출");
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	
}

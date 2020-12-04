<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--  response 객체 메소드
		  getCharacterEncoding() : 응답할 때 문자 인코딩을 얻어올때
		  addCookie(Cookie) : 쿠키를 지정할 떄
		  sendRedirect(URL) : 이동하고자 하는 URL 을 지정할 때  -->
	<%! int age; %>
	<%
		String str = request.getParameter("age");
		age = Integer.parseInt(str);
		
		if(age >= 19){
			response.sendRedirect("a.jsp?age=" + age);
		} else {
			response.sendRedirect("b.jsp?age=" + age);
		}
	%>
</body>
</html>
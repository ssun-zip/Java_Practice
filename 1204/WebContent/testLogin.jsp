<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import = "java.net.URLEncoder" %>
<%
String id = "ssun123";
String pwd = "1234";
String name = "sunny";
request.setCharacterEncoding("UTF-8");
if(id.equals(request.getParameter("id")) && pwd.equals(request.getParameter("pwd")) ) {
	// 이름과 비밀번호가 맞으면
	// 이름을 받아 main.jsp 로 이름과 함꼐 uri 생성하여 보낸다. 
	response.sendRedirect("main.jsp?name=" + URLEncoder.encode(name, "UTF-8"));
} else {
	// password 랑 id가 다르면 로그인폼으로 다시 돌아가게 한다. 
	response.sendRedirect("loginForm1.html");
}
%>
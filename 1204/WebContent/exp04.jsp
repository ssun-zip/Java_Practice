<%! String str = "hello";
	int a = 5, b = -5;
	public int abs(int n) {
		if(n < 0) {
			n = -n;
		}
		return n;
	}
%>
<%! int global_cnt = 0; %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="java.util.Date,java.util.Calendar"%>
<%@page import = "java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=str%> <br>
	<%=a %> 의 절대값 : 
	<%=abs(a) %> <br>
	<%= b %> 의 절대값 :
	<%=abs(b) %> <br>
	<!--  간단한 인사말 출력기 하기  -->
	<%-- 인사말은 String 변수에 저장한다. --%>
	<% String name = "Angel"; %>
	Hello <%= name %> <br>
	
	<%
		Calendar date = Calendar.getInstance();
		SimpleDateFormat today = new SimpleDateFormat("yyyy/ mm/ dd");
		SimpleDateFormat now = new SimpleDateFormat("hh시 mm분 ss초");
	%>
	오늘은 <b> <%= today.format(date.getTime()) %></b> 입니다 <br>
	지금 시각은 <b> <%= now.format(date.getTime()) %></b> 입니다. <br>
	
	<%
		int local_cnt = 0;
	out.print("<br> local_cnt : ");
	out.print(++local_cnt);
	out.print("<br> global_cnt : ");
	out.print(++global_cnt); 
	%> <br>
	
	<%
		int count = 0;
		out.print("count : ");
		out.println(++count);
	%>
</body>
</html>
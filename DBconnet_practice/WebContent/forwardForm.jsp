<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!--  
	연동된 페이지 :
	forwardForm -- forwardTest -- forwardResult
	사용자가 나이를 입력하게되면 19세 이상인지 이하인지를 판별한후에,
	성인일 경우에는 결론 페이지에 나이와 이름 (default : 홍길동) 출력하는 페이지생성하고
	미성년자일 경우에는 alert를 띄우고 다시 원본 페이지로 넘어온다. 
 -->
</head>
<body>
	입장하려면 나이를 입력하세요 <br>
	<form action = "forwardTest.jsp">
		<input type = "text" name = "age">
		<input type = "submit" value = "입징">
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<body bgcolor="red">
이 파일은 red.jsp입니다. <br>
브라우저에 배경색이 빨간색으로 나타날까요?<br>
노란색으로 나타날까요?<hr>
forward 액션 태그가 실행되면 이 페이지의 내용은 출력되지 않습니다. <br>
<jsp:forward page="yellow.jsp" />
<!--  red page 가 yellow.jsp 로 forward 하여 해당 파일에 있는 text 는 출력되지않고 바로
	 yellow page 의 배경색과 text 들이 나온다.  -->
</body>
</html>
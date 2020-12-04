<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%! String str = "안녕하세요!";
	 	int a = 5, b = -5;
	 	
	 	public int abs(int n) {
	 		/*음수인 숫자는 음수로 변환해 준다.*/
	 		if( n < 0) {
			 	n = -n;
		 	}
		 	return n;
	 	}
	 %>
	 <%
	 	out.print(str + "<br>");
	 	out.print(a + "의 절대값 : " + abs(a) + "<br>");
	 	/* b는 음수인데 절대값이기 때문에 양수로 변환 */
	 	out.print(b + "의 절대값 : " + abs(b) + "<br>");
	 %>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	int age = Integer.parseInt(request.getParameter("age"));
	if(age <= 19) {
%>
<script type = "text/javascript"> 
	alert("19세 미만으로 입장 불가능")
	history.go(-1)
</script>
<%
	} else {
		// 주어진 name이 있다면 새로운 값으로 업데이터 된다.
		// 하지만 name의 value가 주어지지 않았다면 홍길동으로 지정한다. 
		//setAttribute은 name은 자연스럽게 HTML 에서 부를때 lowercase 로 바꾼다. 
		request.setAttribute("name", "홍길동");
		/*
		RequestDispatcher ?
		라이언트로부터 들어온 요청을 JSP/Servlet내에서 원하는 자원으로 요청을 넘기는 역할. (특정 자원 처리)
		forwardForm.jsp로 들어온 요청을 forwardTest 의 RequestDispatcher 이용하여 forwardResult로 요청을 
		보낼 수 있다. forwardTest의 결과를 다시 forwardForm의 결과에 포함시킬수 있다. 
		*/
		RequestDispatcher dispatcher = request.getRequestDispatcher("forwardResult.jsp");
		dispatcher.forward(request, response);
	}
%>
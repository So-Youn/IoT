<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--WEB-INF 밑에 있으면 일반적인 jsp파일로 실행이 되지 않는다.
    이렇게 경로로 인식시켜서 작업을 하면 뷰가 웹에서 보여지지 않게 할 수 있다.  -->
	<h1>스프링 web MVC 구축하기</h1>
	<hr/>
	<h3><%=request.getAttribute("msg") %></h3>
	<h3>jsp로 코드 출력하기 : <%=request.getAttribute("msg") %></h3>
	<h3>EL로 출력하기 : ${msg}</h3>
</body>
</html>
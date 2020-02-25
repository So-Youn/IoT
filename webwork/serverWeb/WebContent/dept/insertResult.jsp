<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>응답화면 분리</h1>
	<hr/>
	<% 
	 int result = (Integer)request.getAttribute("result");
	%>
	<h2><%=result %>개의 행 삽입 성공</h2>
</body>
</html>
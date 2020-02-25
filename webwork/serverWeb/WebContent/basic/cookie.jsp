<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<% 
	 Cookie cookie = Cookie("cookieN","cookieV"); //쿠키이름,쿠키value
	 cookie.setMaxAge(60*60); //1시간
	 response.addCookie(cookie);
	 
	%>
	<a href="cookieget.jsp">cookieget</a>
</body>
</html>
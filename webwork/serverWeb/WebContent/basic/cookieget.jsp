<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
	Cookie[] cookie = requset.getCookie();
	
	for(int i =0;i<cookie.length;i++){
		String str =cookie[i].getName();
		if(str.equals("cookieN")){
			out.println("cookies["+i+"]name:"+cookie);
			
		}
	}
	%>
</body>
</html>
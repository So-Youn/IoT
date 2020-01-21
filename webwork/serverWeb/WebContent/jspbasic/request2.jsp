<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<% request.setCharacterEncoding("euc-kr"); %>
	<h2>취미와 가보고 싶은 국가 결과</h2>
	<%
	//Enumeration e = request.getParameterNames();
	//Enumeration<String>을 이용하면 e.nextElement()에서 String으로 자료 유형 변환 필요 없이 반환값을 
	//String 유형변수 name에 저장할 수 있다.
	Enumeration<String> e = request.getParameterNames();
	while(e.hasMoreElements()){
		//String name = (String)e.nextElements();
		String name = e.nextElement();
		String[] data = request.getParameterValues(name);
		if(data !=null){
			for( String eachdata : data){
				out.println(eachdata+" ");
			}
		}
		out.println("<p>");
	}
	
	%>
</body>
</html>
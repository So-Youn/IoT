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
	<h2>��̿� ������ ���� ���� ���</h2>
	<%
	//Enumeration e = request.getParameterNames();
	//Enumeration<String>�� �̿��ϸ� e.nextElement()���� String���� �ڷ� ���� ��ȯ �ʿ� ���� ��ȯ���� 
	//String �������� name�� ������ �� �ִ�.
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
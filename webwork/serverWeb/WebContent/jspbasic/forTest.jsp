<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table style="border-collapse: collapse;border:solid 1px">
	<%
		for(int i =1;i<=10;i++){
	%>
	<tr>
		<td style="border: solid 1px"><%=i%></td>
	</tr>
	<% } %>
	</table>
</body>
</html>
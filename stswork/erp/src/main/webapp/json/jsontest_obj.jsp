<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
 <title>인사관리시스템</title>
  <meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript">
		//자바스크립트 객체 선언
		var person = {
				name:"김서연",
				age:"25",
				like:["자바","서블릿","하둡"],	/* 배열 */
				addr:{						/* Object */
					zipcode:"11-22",
					addr1:"인천시",
					addr2:"남구"
				},
				history:[			/* 배열 */
				    { 
				    	subject:"java",
				    	month:"11"
				    },
				    {
				    	subject:"servlet",
				    	month:"1"
				    },
				    {
				    	subject:"spring",
				    	month:"1"
				    },
				    {
				    	subject:"hadoop",
				    	month:"2"
				    }
				]				
		}
		/* 자바스크립트의 배열처럼 접근해서 사용하기 
			객체.변수
			객체.배열
		*/
		document.write("<h3>"+person.name+"</h3>");
		document.write("<h3>"+person.age+"</h3>");
		document.write("<h3>"+person.addr.addr1+"</h3>");
		document.write("<h3>"+person.like[0]+"</h3>");
		document.write("<h3>"+person.history[0].subject+"</h3>");
	</script>
</body>
</html>












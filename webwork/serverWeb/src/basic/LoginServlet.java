package basic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		//1.요청정보 추출
		req.setCharacterEncoding("euc-kr");
		
		String id = req.getParameter("id"); // test.html의 태그 속 name에 해당하는 값
		String pass = req.getParameter("pass");
		
		System.out.println("아이디: " + id);
		System.out.println("패스워드: " + pass);
	}

}

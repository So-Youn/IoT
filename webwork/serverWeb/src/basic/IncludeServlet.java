package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.DeptDTO;

/**
 * Servlet implementation class IncludeServlet
 */
@WebServlet(name = "include", urlPatterns = { "/servereWeb/include.do" })
public class IncludeServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter pw = response.getWriter();
		pw.println("<h1>include화면</h1>");
		pw.println("<hr/><hr/><hr/><hr/>");
		
		//1. 데이터 공유하기 - request 공유
		DeptDTO dto = new DeptDTO("001", "전산실", "", "", "");
		request.setAttribute("mydata", dto);
		System.out.println("IncludeServlet실행완료");
	
		//2. 요청 재지정 - include
		RequestDispatcher rd = request.getRequestDispatcher("/jspbasic/subPage.jsp");
		rd.include(request, response);
	
	}


}

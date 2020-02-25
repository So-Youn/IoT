package dept;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet(name = "delete", urlPatterns = { "/dept/delete.do" })
public class DeleteServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		//1.요청 정보 추출
		String deptNo = request.getParameter("deptno");
		
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter pw = response.getWriter();
		
		//2.비즈니스 메서드 호출
		DeptDAO dao = new DeptDAO();
		int result = dao.delete(deptNo);
		
		/*pw.print("<h1>삭제 성공</h1><hr/>");
		pw.print("<h4>" + result + "개 삭제</h4>");
		pw.print("<a href='/serverweb/dept/list.do'>목록 보기</a>");*/
		
		
		//3.요청 재지정
		response.sendRedirect("/serverweb/list.do");
	
	
	
	}

}

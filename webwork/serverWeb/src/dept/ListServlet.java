package dept;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListServlet
 */
@WebServlet(name = "list", urlPatterns = { "/list.do" })
public class ListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");
		
		DeptDAO dao = new DeptDAO();
		ArrayList<DeptDTO> list = dao.getDeptList();
		
		request.setAttribute("arrList", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("/dept/list.jsp");
		rd.forward(request, response);
	
	}

}

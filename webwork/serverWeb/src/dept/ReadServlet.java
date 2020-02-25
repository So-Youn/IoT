package dept;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.DeptDAO;
import dept.DeptDTO;

/**
 * Servlet implementation class ReadServlet
 */
@WebServlet(name = "deptRead", urlPatterns = { "/dept/read.do" })
public class ReadServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr"); //POST방식에서만 적용
		response.setContentType("text/html;charset=euc-kr");
		
		// 요청정보추출
		//	- 클라이언트가 직접 폼태그에 입력한 데이터 필요에 의해서 넘긴 파라미터 추출
		//	- 기본설정인 경우 POST방식에서만 적용, get방식인 경우 적용하려면 server.xml의 설정을 변경한다.
		
		String info = request.getParameter("Info");
		String deptNo = request.getParameter("deptno");
		System.out.println("한글 정보 추출: " + info);
		
		// 비지니스 메서드 호출
		//	- DeptDAO 클래스에 메서드 추가하고 호출하기
		DeptDAO dao = new DeptDAO();
		DeptDTO dto =  dao.read(deptNo);
		// jsp로 넘겨 줄 데이터 공유하기
		request.setAttribute("dto", dto);
		
		// 요청재지정(forward) - 응답할 jsp 요청하기
		RequestDispatcher rd = request.getRequestDispatcher("/dept/dept_read.jsp");
		rd.forward(request, response);
	}

}

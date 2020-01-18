package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalcServlet
 */
@WebServlet(name = "calc", urlPatterns = { "/calc.do" })
public class CalcServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. ��û���� ���
		request.setCharacterEncoding("euc-kr");
		
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		String method = request.getParameter("method");
		
		//2. �����Ͻ� �޼��� ȣ��
		CalcLogic logic = new CalcLogic();
		int result = logic.calc(num1,method,num2);
		
		//3. ����ȭ�� ����
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter pw = response.getWriter();
		pw.print("<h1>�����</h1>");
		pw.print("<h3>num1�� " + num1 + "�� num2�� " + num2 + "��<br/>������ ����� " + result + "�Դϴ�.</h3>");


	}

}

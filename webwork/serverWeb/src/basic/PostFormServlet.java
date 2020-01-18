package basic;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PostFormServlet
 */
@WebServlet(name = "mypost", urlPatterns = { "/mypost.do" })
public class PostFormServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		String id = request.getParameter("userId");
		String name = request.getParameter("userName");
		String pass = request.getParameter("passwd");
		String gender = request.getParameter("gender");
		String job = request.getParameter("job");
		String[] arrFavorite = request.getParameterValues("item");

		System.out.println("Customer");
		System.out.println("------------------------");
		System.out.println("���̵�: " + id);
		System.out.println("����: " + name);
		System.out.println("��й�ȣ: " + pass);
		System.out.println("����: " + gender);
		System.out.println("����: " + job);
		System.out.print("Favorites: ");
		for (String string : arrFavorite) {
			System.out.print(string + " ");
		}
	}
}

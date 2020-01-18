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
		System.out.println("아이디: " + id);
		System.out.println("성명: " + name);
		System.out.println("비밀번호: " + pass);
		System.out.println("성별: " + gender);
		System.out.println("직업: " + job);
		System.out.print("Favorites: ");
		for (String string : arrFavorite) {
			System.out.print(string + " ");
		}
	}
}

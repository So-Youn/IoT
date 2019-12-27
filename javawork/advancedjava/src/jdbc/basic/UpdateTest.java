package jdbc.basic;
//2번 board num의 id를 kang으로 수정.

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateTest {
	public static void main(String[] args) {
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String user = "scott";
	String password = "tiger";
	String sql = "update tb_board set id = 'kang' where BOARDNUM = 3 ";
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("드라이버 로딩성공");
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("연결성공"+con);
		Statement stmt = con.createStatement();
		//System.out.println("sql 실행하기 위한 객체정보"+stmt);
		int result = stmt.executeUpdate(sql);
		
	}catch(ClassNotFoundException e) {
		System.out.println("드라이버 로딩 실패");
	}catch(SQLException e) {
		System.out.println("연결실패 "+e.getMessage());
	}

	}

}

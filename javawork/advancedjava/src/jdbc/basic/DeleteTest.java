package jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteTest {

	public static void main(String[] args) {
		//연결 문자열 - 어떤 DBMS를 쓰느냐에 따라 형식이 달라진다.
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				//접속계정
				String user = "scott";
				//접속계정 패스워드
				String password = "tiger";
				StringBuffer sql = new StringBuffer();
				sql.append("delete tb_board");
				sql.append("where boardnum = 3");
				try {
					// 1. 오라클 드라이버 로딩
					Class.forName("oracle.jdbc.driver.OracleDriver");
					System.out.println("드라이버로딩 성공!!");
					// 2. DBMS에 연결하기 - 연결정보를 정의
					// ==> DBMS에 연결하고 연결정보를 Connection타입으로 반환한다.
					Connection con = DriverManager.getConnection(url,user,password);
					System.out.println("연결 성공: " + con);
					// 3. sql을 실행하기 위한 객체를 생성 - 연결정보와 연결시켜야 하므로 Connection객체를 이용해서 생성
					Statement stmt = con.createStatement();
					int result = stmt.executeUpdate(sql.toString());
					System.out.println(result + "개 행 삭제 성공");
				} catch(ClassNotFoundException e) {
					System.out.println("드라이버로딩 실패");
				} catch(SQLException e) {
					System.out.println("연결실패: " + e.getMessage());
					e.printStackTrace();
				}
	}

}

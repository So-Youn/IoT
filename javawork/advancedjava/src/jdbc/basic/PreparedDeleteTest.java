package jdbc.basic;
//UpdateTest.java를 rename해서 작업

//sql문만 delete문으로 변경해서 시행해보기
//     --------- 3번 boardnum의 게시물을 삭제

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedDeleteTest {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		PreparedDeleteTest obj = new PreparedDeleteTest();
		System.out.println("번호");
		int boardnum = key.nextInt();
		System.out.println();
		obj.Delete(boardnum);
		key.close();

	}
	public void Delete(int boardnum){
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "scott";
		String password = "tiger";
		Connection con = null;
		PreparedStatement stmt = null;
		String sql = "delete tb_board where boardnum= ?";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩성공");
			con = DriverManager.getConnection(url, user, password);
			System.out.println("연결성공" + con);
			stmt = con.prepareStatement(sql);
			stmt.setInt(1,boardnum);
			int result = stmt.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		} catch (SQLException e) {
			System.out.println("연결실패 " + e.getMessage());
			e.printStackTrace(); // 오류추적 메시지
		}finally { 
			try {	
				if(stmt!=null)stmt.close();
				if(con!=null)con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		
	}
	

}

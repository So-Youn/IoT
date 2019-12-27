package jdbc.basic;
//외부에서 입력 받아 처리하도록 변경.
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedInsertTest {
	public static void main(String[] args) {	
		Scanner key = new Scanner(System.in);
		PreparedInsertTest obj = new PreparedInsertTest();
		System.out.println("********게시글 등록하기*********");
		System.out.print("아이디 :");
		String id = key.next();
		System.out.print("제목 : ");
		String title =key.next();
		System.out.print("내용 :");
		String content = key.next();
		System.out.println();
		obj.insert(id,title,content);
		key.close();
	}
	public void insert(String id, String title, String content) {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "scott";
		String password = "tiger";
		//command line 에서 작업한 것은 반드시 commit 이나 rollback을 작업하고 실행하기.
		Connection con = null;
		PreparedStatement stmt = null;
		/*String sql = "insert into tb_board values(board_seq.nextval,'"+
		             id+ "','" + title + "','" + content+ "','" + "',sysdate,0)";
		             statement 방식의 동적 sql*/
		String sql = "insert into tb_board values (board_seq.nextval,?,?,?,sysdate,0)";
		//preparestatement 방식의 동적 sql
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버로딩 성공!!");
			con = DriverManager.getConnection(url, user, password);
			System.out.println("연결 성공" + con); 
			// 1. preparedStatement생성
			stmt = con.prepareStatement(sql);
			// 2. ?에 값 전달하기
			stmt.setString(1,id);
			stmt.setString(2,title);
			stmt.setString(3,content);
			int result = stmt.executeUpdate();
			//3. 실행하기
			System.out.println(result + "개 행 삽입성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		} catch (SQLException e) {
			System.out.println("연결 실패 : " + e.getMessage());
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

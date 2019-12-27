package jdbc.board.exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

// tb_board 테이블을 엑세스하는 기능이 정의된 클래스
public class BoardDAOImpl implements BoardDAO {
	
	public BoardDAOImpl() {
		
	}
	public int insert(BoardDTO board) {	
		System.out.println("dto사용 메서드: " + board);
		
		String sql = "insert into tb_board values(board_seq.nextval, ?, ?, ?, sysdate, 0)";
		Connection con = null;
		PreparedStatement ptmt = null;
		int result = 0;	// 메서드의 실행 결과가 저장될 변수
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, board.getId());
			ptmt.setString(2, board.getTitle());
			ptmt.setString(3, board.getContent());
			result = ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace(); // 오류 추적
		} finally {
			DBUtil.close(null, ptmt, con);
		}
		return result;
	}
	
	public int insert(String id, String title, String content) {	
		String sql = "insert into tb_board values(board_seq.nextval, ?, ?, ?, sysdate, 0)";
		
		Connection con = null;
		PreparedStatement ptmt = null;
		int result = 0;	// 메서드의 실행 결과가 저장될 변수
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, id);
			ptmt.setString(2, title);
			ptmt.setString(3, content);
			result = ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace(); // 오류 추적
		} finally {
			DBUtil.close(null, ptmt, con);
		}
		return result;
	}
	
	public int update(String id, int boardNum) {
		String sql = "update tb_board set id = ? where boardnum = ?";
		
		Connection con = null;
		PreparedStatement ptmt = null;
		int result = 0;		
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, id);
			ptmt.setInt(2, boardNum);
			result = ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(null, ptmt, con);
		}
		return result;
	}
	
	public int delete(int boardNum) {
		StringBuffer sql = new StringBuffer("delete from tb_board ");
		sql.append("where boardnum = ?");
		
		Connection con = null;
		PreparedStatement ptmt = null;
		int result = 0;
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql.toString());
			ptmt.setInt(1, boardNum);
			result = ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(null, ptmt, con);
		}
		return result;
	}
	
	public ArrayList<BoardDTO> select() {
		String sql = "select * from tb_board";

		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			rs = ptmt.executeQuery();

			while (rs.next()) {
				BoardDTO board = new BoardDTO();
				board.setBoardNum(rs.getInt("boardNum"));
				board.setId(rs.getString("id"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setWriteDate(rs.getDate("write_date"));
				board.setHit(rs.getInt("hit"));
				list.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ptmt, con);
		}
		return list;
	}
	
}
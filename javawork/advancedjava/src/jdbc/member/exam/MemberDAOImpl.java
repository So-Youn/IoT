package jdbc.member.exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.board.exam.DBUtil;

public class MemberDAOImpl implements MemberDAO {

	@Override
	public int insert(MemberDTO user) {
		System.out.println(user);
		Connection con = null;
		PreparedStatement ptmt = null;
		String sql = "insert into member values(?, ?, ?, ?, ?, sysdate, 1000)";
		int result = 0;
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, user.getId());
			ptmt.setString(2, user.getPass());
			ptmt.setString(3, user.getName());
			ptmt.setString(4, user.getAddr());
			ptmt.setString(5, user.getDeptno());
			result = ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(null, ptmt, con);
		}
		
		return result;
	}
	
	@Override
	public int update(String id, String addr) {
		Connection con = null;
		PreparedStatement ptmt = null;
		String sql = "update member set addr = ? where id = ?";
		int result = 0;
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, addr);
			ptmt.setString(2, id);
			result = ptmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(null, ptmt, con);
		}
		
		return result;
	}

	@Override
	public int delete(String id) {
		Connection con = null;
		PreparedStatement ptmt = null;
		String sql = "delete from member where id = ?";
		int result = 0;
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, id);
			result = ptmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(null, ptmt, con);
		}
		
		return result;
	}


	@Override
	public ArrayList<MemberDTO> memberList() {
		ArrayList<MemberDTO> memberList = new ArrayList<MemberDTO>();
		MemberDTO member =null;
		String sql = "select * from member";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnect();
			// select문을 실행
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {// => 레코드를 조회하기 위해서는
				// 1. 조회한 레코드의 컬럼을 읽어서 DTO로 변환하는 작업
				member = new MemberDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getDate(6), rs.getInt(7));
				// 2. DTO로 변환된 레코드를 ArrayList에 추가
				memberList.add(member);
		}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, stmt, con);
		}
		return memberList;
	}

	@Override
	public ArrayList<MemberDTO> findByAddr(String addr) {
		ArrayList<MemberDTO> memberlist = new ArrayList<MemberDTO>();
		String sql = "select * from member where addr like ?";
		
		MemberDTO member = null;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			con =DBUtil.getConnect();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, "%"+addr+"%");
			rs = stmt.executeQuery(); //sql 실행 명령
			while(rs.next()) {
				member = new MemberDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getDate(6), rs.getInt(7));
				memberlist.add(member);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs, stmt, con);
		}
		
		return memberlist;
	}

	@Override
	public MemberDTO Login(String id, String pass) {
		MemberDTO member = null;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "select * from member where id =? and pass = ?";
		
		try {
			con = DBUtil.getConnect();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.setString(2, pass);
			rs = stmt.executeQuery();

			while(rs.next()) {
				member = new MemberDTO(rs.getString(1), rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, stmt, con);
		}
	
		return member;
	}
}
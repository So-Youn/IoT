package jdbc.member.exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	public void select() {
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		
		String sql = "select * from member";
		
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			rs = ptmt.executeQuery();
			ArrayList<MemberDTO> arrMember = new ArrayList<MemberDTO>();
			while(rs.next()) {
				MemberDTO member = new MemberDTO();
				member.setId(rs.getString("id"));
				member.setPass(rs.getString("pass"));
				member.setName(rs.getString("name"));
				member.setAddr(rs.getString("addr"));
				member.setDeptno(rs.getString("deptno"));
				member.setHireDate(rs.getDate("hiredate"));
				member.setPoint(rs.getInt("point"));
				arrMember.add(member);			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ptmt, con);
		}
	}
}
package dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fw.DBUtil;

public class DeptDAO {
	public int delete(String deptNo) {
		Connection con = null;
		PreparedStatement ptmt = null;
		String sql = "delete from mydept where deptno = ?";
		int result = 0;

		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, deptNo);
			result = ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(null, ptmt, con);
		}
		return result;
	}

	public ArrayList<DeptDTO> getDeptlist() {
		Connection con = null;
		PreparedStatement ptmt = null;
		String sql = "select * from mydept";
		ArrayList<DeptDTO> list = new ArrayList<DeptDTO>();
		ResultSet rs = null;
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			rs = ptmt.executeQuery();
			DeptDTO dto = null;
			while (rs.next()) {
				dto = new DeptDTO(rs.getString("deptNo"), rs.getString("deptName"), rs.getString("loc"),
						rs.getString("tel"), rs.getString("mgr"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ptmt, con);
		}
		return list;
	}
	
	public int insert(DeptDTO dto) {
		Connection con = null;
		PreparedStatement ptmt = null;
		String sql = "insert into mydept values(?, ?, ?, ?, ?)";
		int result = 0;
		
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, dto.getDeptNo());
			ptmt.setString(2, dto.getDeptName());
			ptmt.setString(3, dto.getLoc());
			ptmt.setString(4, dto.getTel());
			ptmt.setString(5, dto.getMgr());
			result = ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(null, ptmt, con);
		}
		return result;
	}
}

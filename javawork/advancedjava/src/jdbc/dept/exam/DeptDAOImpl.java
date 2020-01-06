package jdbc.dept.exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.board.exam.DBUtil;

public class DeptDAOImpl implements DeptDAO{
	
	@Override
	public int insert(DeptDTO dept) {
		System.out.println(dept);
		Connection con = null;
		PreparedStatement stmt = null;
		String sql="insert into dept values(?,?,?)";
		int result = 0;
		try {
			con = DBUtil.getConnect();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, dept.getDeptno());
			stmt.setString(2, dept.getDname());
			stmt.setString(3, dept.getLoc_code());
			result = stmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(null, stmt, con);
		}
		
		return result;
	}

	@Override
	public DeptDTO getDeptInfo() {
		DeptDTO dept = null;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from dept";
		try {
			con = DBUtil.getConnect();
			// select문을 실행
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
		if (rs.next()) {
			dept = new DeptDTO(rs.getString(1), rs.getString(2), rs.getString(3));
		}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, stmt, con);
		}
		return dept; // DTO 리턴
	}
	

	@Override
	public int update(DeptDTO dept) {
		
		Connection con = null;
		PreparedStatement stmt = null;
		String sql = "update dept set dname = ? and loc_code=? where deptno = ?";
		int result = 0;
		try {
			con = DBUtil.getConnect();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, dept.getDname());
			stmt.setString(2, dept.getLoc_code());
			stmt.setString(3, dept.getDeptno());
			result = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(null, stmt, con);
		}
		
		return result;
	}

	@Override
	public int delete(String deptno) {
		Connection con = null;
		PreparedStatement stmt = null;
		String sql = "delete from dept where deptno = ?";
		int result = 0;
		try {
			con = DBUtil.getConnect();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, deptno);
			result = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(null, stmt, con);
		}
		
		return result;
	}

	@Override
	public ArrayList<DeptDTO> getDeptList() {
		ArrayList<DeptDTO> deptlist = new ArrayList<DeptDTO>();
		String sql = "select * from dept ";

		DeptDTO dept = null;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnect();
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery(); 
			while (rs.next()) {
				dept = new DeptDTO(rs.getString(1), rs.getString(2), rs.getString(3));
				deptlist.add(dept);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, stmt, con);
		}

		return deptlist;
	}

	@Override
	public ArrayList<EmpDTO> getMemberList(String deptno) {
		ArrayList<EmpDTO> emplist = new ArrayList<EmpDTO>();
		String sql = "select d.dname e.ename from emp e, dept d where e.deptno = d.deptno";
		int result = 0;
		EmpDTO emp= null;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnect();
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery(); 
			while (rs.next()) {
				emp = new EmpDTO(rs.getInt(1), rs.getString(2), rs.getString(3));
				emplist.add(emp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, stmt, con);
		}

		return emplist;
	
	}
	
}

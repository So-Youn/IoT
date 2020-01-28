package dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fw.DBUtil;

public class DeptDAO {
	// 전체 목록 출력
	public ArrayList<DeptDTO> getDeptList() {
			System.out.println("getDeptList()호출 - parameter검출");
			String sql ="select * from mydept";
			ArrayList<DeptDTO> deptlist = new ArrayList<DeptDTO>();
			DeptDTO dept = null;
			Connection con = null;
			PreparedStatement ptmt = null;
			ResultSet rs = null;
			try {
				con =DBUtil.getConnect();
				ptmt=con.prepareStatement(sql);
				rs = ptmt.executeQuery();
				while(rs.next()){
					dept = new DeptDTO(rs.getString(1),rs.getString(2),rs.getString(3),
							rs.getString(4),rs.getString(5));
					deptlist.add(dept);
					
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				DBUtil.close(rs, ptmt, con);
			}
			return deptlist;
	}
	
	

	public int insert(DeptDTO dept) {
		System.out.println("DOT사용 메소드" + dept);
		Connection con = null;
		PreparedStatement ptmt = null;
		String sql = "insert into mydept values (?,?,?,?,?)";
		int result = 0;
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, dept.getDeptNo()); // ? setting
			ptmt.setString(2, dept.getDeptName());
			ptmt.setString(3, dept.getLoc());
			ptmt.setString(4, dept.getTel());
			ptmt.setString(5, dept.getMgr());
			result = ptmt.executeUpdate();
			System.out.println(result + "개 행 삽입 성공");
		} catch (SQLException e) {
			System.out.println("연결실패" + e.getMessage());
		} finally {
			DBUtil.close(null, ptmt, con);
		}
		return result;
	}
	public int delete(String DeptNo) {
		Connection con = null;
		PreparedStatement ptmt = null;
		String sql = "delete from mydept where deptno=?";
		int result =0;
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1,DeptNo);
			result = ptmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(null, ptmt, con);
		}
		return result;
		
	}
	
	public DeptDTO read(String DeptNo) {
		System.out.println("dao의 read호출");
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		DeptDTO dept = null;
		
		String sql = "select * from mydept where DeptNo=?";
		try {
			con =DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, DeptNo);
			rs = ptmt.executeQuery();	//select실행 - 결과가 레코드 한개
			//실행 결과를 자바객체로 변환
			// - 레코드가 여러개면 : DTO로 레코드를 변환하고 ArrayList에 add
			// - 레코드가 한개 : DTO로 레코드 변환
			//Primary키로 묶어서 레코드 출력시 값이 1개 
			//record문이 1개이면 있는지 없는지만 확인하는 if문 사용
 			//while(rs.next()) {	//레코드 검색
			if(rs.next()) {
			dept = new DeptDTO(rs.getString(1),rs.getString(2),
						rs.getString(3),rs.getString(4),rs.getString(5));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs, ptmt, con);
		}
		
		return dept;
	}
}

package dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fw.DBUtil;

public class DeptDAO {
	// ��ü ��� ���
	public ArrayList<DeptDTO> getDeptList() {
			System.out.println("getDeptList()ȣ�� - parameter����");
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
		System.out.println("DOT��� �޼ҵ�" + dept);
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
			System.out.println(result + "�� �� ���� ����");
		} catch (SQLException e) {
			System.out.println("�������" + e.getMessage());
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
		System.out.println("dao�� readȣ��");
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		DeptDTO dept = null;
		
		String sql = "select * from mydept where DeptNo=?";
		try {
			con =DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, DeptNo);
			rs = ptmt.executeQuery();	//select���� - ����� ���ڵ� �Ѱ�
			//���� ����� �ڹٰ�ü�� ��ȯ
			// - ���ڵ尡 �������� : DTO�� ���ڵ带 ��ȯ�ϰ� ArrayList�� add
			// - ���ڵ尡 �Ѱ� : DTO�� ���ڵ� ��ȯ
			//PrimaryŰ�� ��� ���ڵ� ��½� ���� 1�� 
			//record���� 1���̸� �ִ��� �������� Ȯ���ϴ� if�� ���
 			//while(rs.next()) {	//���ڵ� �˻�
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

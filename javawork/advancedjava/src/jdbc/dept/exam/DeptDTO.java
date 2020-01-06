package jdbc.dept.exam;

public class DeptDTO {
	private String deptno;
	private String dname;
	private String loc_code;
	
	
	public DeptDTO(){
		
	}
	public DeptDTO(String deptno, String dname,String loc_code) {
		this.deptno = deptno;
		this.dname = dname;
		this.loc_code = loc_code;
	}
	@Override
	public String toString() {
		return "DeptDTO [deptno=" + deptno + ", dname=" + dname + ", loc_code=" + loc_code + "]";
	}
	public String getDeptno() {
		return deptno;
	}
	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc_code() {
		return loc_code;
	}
	public void setLoc_code(String loc_code) {
		this.loc_code = loc_code;
	}
	
}

package jdbc.dept.exam;

public class EmpDTO {
	private int empno;
	private String ename;
	private String deptno;
	
	public EmpDTO() {
		
	}

	public EmpDTO(int empno, String ename, String deptno) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.deptno = deptno;
	}

	@Override
	public String toString() {
		return "EmpDTO [empno=" + empno + ", ename=" + ename + ", deptno=" + deptno + "]";
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getDeptno() {
		return deptno;
	}

	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}
	
	
}

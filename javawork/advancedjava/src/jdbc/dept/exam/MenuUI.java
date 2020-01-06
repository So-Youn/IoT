package jdbc.dept.exam;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuUI {
	Scanner key = new Scanner(System.in);
	DeptDAO dep = new DeptDAOImpl();

	public void insertMenu() {
		System.out.println("*******부서등록********");
		System.out.print("부서번호 :");
		String deptno = key.next();
		System.out.print("부서 이름:");
		String dname = key.next();
		System.out.print("지역 코드:");
		String loc_code = key.next();

		DeptDTO user = new DeptDTO(deptno, dname, loc_code);
		int result = dep.insert(user);
		if (result > 0) {
			System.out.println("부서 등록 성공");
		} else {
			System.out.println("부서 등록 실패");
		}
	}

	public void deleteMenu() {
		System.out.println("*******부서삭제********");
		System.out.print("부서 번호:");
		String deptno = key.next();
		// 여기에서 EmpDAO의 메소드를 호출하세요
		int result = dep.delete(deptno);
		if (result > 0) {
			System.out.println("부서 삭제 성공");
		} else {
			System.out.println("부서 삭제 실패");
		}
	}

	public void selectMenu() {
		System.out.println("*******전체부서조회********");
		// 여기에서 BoardDAO의 메소드를 호출하세요
		ArrayList<DeptDTO> deptlist = dep.getDeptList();
		int size = deptlist.size();
		for (int i = 0; i < size; i++) {
			DeptDTO dept = deptlist.get(i);
			System.out.println(dept.getDeptno() + "\t" + dept.getDname() + "\t" + dept.getLoc_code());
		}
	}
	public void updateMenu(DeptDTO dept){
		System.out.println("*******부서수정********");
		System.out.print("부서 번호:");
		String deptno = key.next();
		
		//여기에서 EmpDAO의 메소드를 호출하세요
		//주소를 변경
		int result = dep.update(dept);
		if(result > 0) {
			System.out.println("사원 수정 성공");
		} else {
			System.out.println("사원 수정 실패");
		}
}
	public void searchMenu() {
		System.out.println("*******모든 부서목록 확인하기********");
		// 여기에서 BoardDAO의 메소드를 호출하세요
		ArrayList<DeptDTO> deptlist = dep.getDeptList();
		int size = deptlist.size();
		for (int i = 0; i < size; i++) {
			DeptDTO dept = deptlist.get(i);
			System.out.println(dept.getDeptno() + "\t" + dept.getDname() + "\t" + dept.getLoc_code());
		}
	}
}

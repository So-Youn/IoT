package Chap03;
//비교연산자 - || , && => 숏컷 연산자 - 모든 항을 검사하지 않고 조건에 만족하면 Skip 하는 경우 발생
public class OprTest04 {
	public static void main(String[] args) {
		int num = 100;
		String str = null; //현재 str은 아무것도 저장되지 않은 변수
		
		// ||연산자는 or 연산자의 특성을 파악하고 첫번째 항이 true이면 뒤의 항은 검사하지 않는다
		System.out.println(num>=100 || str.length()>10);
		/* ||는 예외를 걸러내는데 |는 예외를 걸러내지 못함
		 * ||는 연산자 먼저 check -> 앞에 true 면 뒤에 검사 없이 skip
		 * |는 skip없이 전부 검사
		 * &&연산자는 and 연산자의 특성을 파악하고 첫번째 항이 false 이면 뒤의 항은 검사하지않는다.
		 */
		System.out.println(num<100 && str.length()>10);
	}

}

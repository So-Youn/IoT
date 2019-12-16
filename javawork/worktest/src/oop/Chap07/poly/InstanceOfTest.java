package oop.Chap07.poly;
/*
 * 객체의 타입을 검사하고 작업할 수 있다.
 * InstanceOf연산자 이용
 * 타입 체크 후에 사용하면 명확성을 높일 수 있다.
 */
class A{
	
}
interface IA{
	
}
public class InstanceOfTest {
	public static void main(String[] args) {
		SubA obj = new SubA();
		//obj가 SuperA타입이라면 if블럭을 실행해라,
		//	----------------
		//		ㄴ
		if(obj instanceof SuperA) {
			System.out.println("SuperA 타입이다.");
		}else {
			System.out.println("SuperA타입이 아니다.");
		}
		System.out.println("======================");
		if(obj instanceof InterB) {
			System.out.println("InterB 타입이다.");
		}else {
			System.out.println("InterB타입이 아니다.");
		}
		System.out.println("=====================");
		if(obj instanceof InterC) {
			System.out.println("InterC 타입이다.");
		}else {
			System.out.println("InterC타입이 아니다.");
		}
		System.out.println("=====================");
		if(obj instanceof IA) {
			System.out.println("IA 타입이다.");
		}else {
			System.out.println("IA 타입이 아니다.");
		}
	}
	

}

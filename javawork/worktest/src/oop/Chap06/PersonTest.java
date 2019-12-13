package oop.Chap06;
//Person클래스를 사용하는 클래스
public class PersonTest {

	public static void main(String[] args) {
		Person p1 = new Person("장동건","서울시",45);					//age변수는 private으로 선언되어있으므로 접근할 수 없다.
											//같은 패키지의 클래스에서도 접근할 수 없다.
		System.out.println("성명 :"+p1.getName());
		System.out.println("주소 :"+p1.getAddr());
		System.out.println("나이 :"+p1.getAge());
		
		Person p2 = new Person("김서연","인천시",25);			//new 연산자
	
		System.out.println("성명 :"+p2.getName());
		System.out.println("주소 :"+p2.getAddr());
		System.out.println("나이 :"+p2.getAge());
	}

}

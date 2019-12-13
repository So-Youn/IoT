package oop.Chap07;

import java.util.Random;

public class StaticMethodDemoTest {
	public static void main(String[] args) {
		//API의 static 메소드 접근하기
		//=> static멤버는 인스턴스의 소유가 아니므로 무조건 클래스명으로 접근한다.
		//Static메소드의 호출(클래스 메소드)
		System.out.println(Math.PI);
		System.out.println(Math.random());
		//non-static메소드(일반메소드-인스턴스메소드)
		//객체 생성을 한 후에 참조변수를 통해서 액세스
		Random rand = new Random();
		System.out.println(rand.nextInt());
		
	}

}

package oop.Chap06.constructor;
//메소드의 호출 과정
public class MethodCallExam {
	public void test() {
		first();//test에서 first호출
	}
	public void first() {
		second();
	}
	public void second() {
		System.out.println("second()~~~~");
	}
	//program실행되기 전에 class에 대한 정보와 static 명령이 메모리에 할당된다. 
	//코드가 실행되면서 new를 만나면 heap에 정보가 올려진다. ㅌㄷ
	public static void main(String[] args) {
		MethodCallExam obj = new MethodCallExam();
		obj.test();
	}
}

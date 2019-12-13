package oop.Chap07.poly.email;
public class SenderLogic {
	public void run(Sender obj) {//(SMSSender obj)(EmailSender obj)다 가능. 
							//부모타입의 매개변수로 선언하면 다 받을 수 있기 때문.(parent 타입)
		//Sender클래스의 클래스들을 활용하는 매소드
		//((EmailSender)obj).print(); 불가능.
		System.out.println("실행 완료");
		obj.print();
		
	}
}

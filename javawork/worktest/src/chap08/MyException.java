package chap08;

//사용자 정의 Exception
//일반적으로 exception클래스들의 상위가 exception
public class MyException extends Exception{
	public MyException(String msg) {
		super(msg);
	}
	//MyException이 발생햇을 때 저장하고 싶은 정보가 있거나 처리해야 할 내용이 있는 경우 구현
	
}

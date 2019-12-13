package Test;
//문자형 변수 ch가 영문자 (대문자 또는 소문자) 일 때만 변수 b의 값이 true가 되도록 완성해라.
public class Test04 {

	public static void main(String[] args) {
		char ch = 'ㄹ';
		boolean b = ('a' <= ch && ch <='z') || ('A' <= ch) && (ch<='Z');
		System.out.println(b);
		
		
	}

}

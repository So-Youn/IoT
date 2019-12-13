package Chap04;
//while문 연습
public class WhileTest01 {
	public static void main(String[] args) {
		int i = 1;
		while(i<5) {
			System.out.println("자바프로그래밍 : "+i);
			i++;
		}
		System.out.println("=================");
		i=1; 			//다시 초기화
			
		while(true) { 	//무한 루프
			if(i>5) {
				break;
			}
			System.out.println("자바프로그래밍 : "+i);
			i++;
		}
	}

}

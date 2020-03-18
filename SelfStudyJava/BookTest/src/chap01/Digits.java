package chap01;

import java.util.Scanner;

//2자리의 양수(10 ~ 99)를 입력합니다.
public class Digits {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int no;
		System.out.println("2자리의 정수를 입력하세요.");
		
		do {
			System.out.println("입력 :");
			no = sc.nextInt();
		}while(no<10||no>99);
		//(10 ~ 99) 사이의 값이 아니면 다시 입력하도록 작성
		System.out.println("변수 no의 값은 " + no + "가(이) 되었습니다.");
	}

}

package chap01;

import java.util.Scanner;
//양의 정수값의 자릿수를 구하여 나타냄
public class Exam10 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("양의 정수값의 자릿수를 구합니다.");
		int num;
		do {
			System.out.println("정수 값:");
			num = sc.nextInt();
		}while(num<=0);
		
		int no=0; // 자릿수
		while(num>0) {
			num/=10;
			no++;
		}
		
		System.out.println("그 수는 " + no + "자리입니다.");
	}

}

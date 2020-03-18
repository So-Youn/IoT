package chap01;

import java.util.Scanner;

public class SumWhile {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("a의 값:");
		int a = sc.nextInt();
		
		int b;
		
		while(true) {
			System.out.print("b의 값：");
			b = sc.nextInt();
			if(b>a)
				break;
			System.out.println("a보다 큰 값을 입력하세요!");
		}
		
		System.out.println("b - a는 " + (b - a) + "입니다.");
		
	}

}

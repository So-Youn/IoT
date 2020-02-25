package Beakjoon.step08;

import java.util.Scanner;
/*
 * String -> char -> int 변환
 * 각 숫 자의 아스키코드는 0을 의미하는 48을 빼주면 자신의 수를 가지게 된다.
 * line.charAt(i)를 통해 숫자 값을 얻을 수 있다.
 */
public class Test11720 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int sum =0;
		String line = sc.next();
		for(int i=0;i<num;i++) {
			sum +=line.charAt(i)-'0';
			
		}
		System.out.println(sum);
	}

}

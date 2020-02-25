package Beakjoon.step06;

import java.util.Scanner;

public class Test2562 {
/*	9개의 서로 다른 자연수가 주어질 때, 
 *  이들 중 최댓값을 찾고 그 최댓값이 몇 번째 수인지를 
 *  구하는 프로그램을 작성하시오.*/
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max = 0;
		int index = 0;
		
		for (int i=1;i<=9;i++) {
			int num = sc.nextInt();
			if(num > max) {
				max = num;
				index = i ; 
			}
		}
		System.out.println(max);
		System.out.println(index);
		
		
	}

}

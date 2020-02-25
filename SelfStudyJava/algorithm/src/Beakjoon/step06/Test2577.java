package Beakjoon.step06;

import java.util.Scanner;

public class Test2577 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		sc.close();
		
		int[] counts = new int[10];
		int number = a*b*c;
		while(number>0) {
			counts[number%10]++;
			number /=10;
		}
		for(int i=0;i<counts.length;i++) {
			System.out.println(counts[i]);
		}
	}
}

package Beakjoon.basic;

import java.util.*;

public class Test11022 {
	// Test11021 심화 버전
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		for (int i = 0; i < input; i++) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			if (num1 > 0 && num2 < 10) {
				System.out.println("Case #" + (i + 1) + ": " + num1 + " + " + num2 + " = " + (num1 + num2));
				;
			}
		}
		sc.close();

	}

}

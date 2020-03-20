package chap02;

import java.util.Scanner;

//두 배열이 같은가를 판단
public class ArrayEqual {
	// 두 배열 a, b의 모든 요소가 같은가?

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.print("배열 a의 요솟수：");
		int num = stdIn.nextInt();		// 배열 a의 요솟수
		
		int[] a = new int[num];
		
		for (int i = 0; i < num; i++) {
			System.out.print("a[" + i + "] : ");
			a[i] = stdIn.nextInt();
		}
		System.out.print("배열 b의 요솟수：");
		int num2 = stdIn.nextInt();		// 배열 b의 요솟수
		int[] b = new int[num2];
		
		for (int i = 0; i < num2; i++) {
			System.out.print("b[" + i + "] : ");
			b[i] = stdIn.nextInt();
		}
		System.out.println("배열 a와 b는 " + 
				 (equals(a, b) ? "같습니다."
						 			: "같지 않습니다."));
	}

	private static boolean equals(int[] a, int[] b) {
		if (a.length!=b.length)
		return false;
		for(int i =0;i<a.length;i++)
			if(a[i]!=b[i])
				return false;
		return false;
		
	}

}

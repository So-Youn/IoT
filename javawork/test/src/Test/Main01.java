package Test;

import java.util.Scanner;

public class Main01 {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int X = input.nextInt();
		int[] p = new int[N];
		for (int i = 0; i < N; i++) {
			p[i] = input.nextInt();
		}
		input.close();
		for (int i = 0; i < N ; i++) {
			if (p[i] < X) {
				System.out.print(p[i] + " ");

			}
		}
		
	}
}

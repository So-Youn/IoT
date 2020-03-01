package Beakjoon.step06;

import java.util.*;

public class Test8958 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		String[] line = new String[num+1];
		
		for (int i = 0; i < num; i++) {
			int count = 0;
			int sum = 0;
			line[i] = sc.next();
			for (int j = 0; j < line[i].length(); j++) {
				if (line[i].charAt(j) == 'O') {
					++count;
					sum += count;

				} else {
					count = 0;
				}
			}
			System.out.println(sum);
		}
		sc.close();
	}

}

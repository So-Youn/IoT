package Beakjoon.step06;

import java.util.*;

public class Test1546 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();
		double max = 0;
		double score[] = new double[cnt];
		double sum = 0;
		for (int i = 0; i < cnt; i++) {
			score[i] = sc.nextInt();
			if (score[i] > max) {
				max = score[i];
			}
		}
		for (int i = 0; i < cnt; i++) {
			score[i] = score[i] / max * 100;
			sum += score[i];
		}
		System.out.println(sum / cnt);
	}

}

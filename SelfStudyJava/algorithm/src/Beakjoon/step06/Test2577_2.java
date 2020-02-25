package Beakjoon.step06;

import java.util.Scanner;

//String 클래스 이용
/*
 * valueOf(number) : 해당 number를 String으로 변환하여 반환
 * length() : 문자열의 길이 반환
 * charAt(index) : 해당 문자열의 index에 위치한 문자를 char 형으로 반환한다.
 */
public class Test2577_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		sc.close();

		int[] counts = new int[10];
		String input = String.valueOf(a * b * c);
		for (int i = 0; i < input.length(); i++) {
			counts[input.charAt(i) - '0']++;
		}
		for (int i = 0; i < counts.length; i++) {
			System.out.println(counts[i]);
		}

	}

}

package Beakjoon.step08;

import java.util.Scanner;

public class Test10809 {
//indexOf : 특정 문자열의 index 값 리턴
//탐색하려는 문자열이 존재하지 않는다면 -1 반환
//텍스트의 포함여부 확인은 match() 사용
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		for (char c = 'a';c<='z';c++) {
			System.out.print(input.indexOf(c)+" ");
		}

	}

}

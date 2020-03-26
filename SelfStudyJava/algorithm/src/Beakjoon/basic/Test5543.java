package Beakjoon.basic;
//100~2000 사이의 최솟값 찾기
import java.util.Scanner;

public class Test5543 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int burger = 2001;
		int drink = 2001;
		// 무조건 입력되는 값이 초깃값보다 작도록 2001로 설정해주었다.
		for (int i = 0; i < 3; i++) {
			int value = sc.nextInt();
			if(value <burger) {
				burger = value;
			}
		}
		
		for (int i = 0; i < 2; i++) {
			int value= sc.nextInt();
			if( value <drink) {
				drink = value;
			}
		}
		System.out.println(burger+drink-50);
	}

}

package Beakjoon.step08;
import java.util.*;
public class Test1152 {
	/* 
	 * next()는 공백을 기준으로 한단어씩 입력받는다.
	 * nextLine()은 한 라인 전체를 입력받는다.
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine().trim();
		String[] arr = input.split(" ");
		sc.close();
		if(input.isEmpty()) {
			System.out.println(0);
		}else {
			System.out.println(arr.length);
		}
		
		
	}

}

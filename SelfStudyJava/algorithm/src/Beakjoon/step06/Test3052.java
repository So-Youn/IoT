package Beakjoon.step06;
import java.util.*;
//총 10개의 수를 입력받고 그 수들을 42로 나누고 남은 나머지가 중복 되는지 체크하면 되는 문제
public class Test3052 {
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		int[] remain = new int[10];
		int count=1;
		for(int i=0;i<10;i++) {
			int num = sc.nextInt();
			remain[i] = num%42;
		}
		sc.close();
		Arrays.sort(remain);
		for(int i =0;i<9;i++) { //중복이 있는지 검증
			if(remain[i]!=remain[i+1]) {
				count++;
			}
		}
	System.out.println(count);
	}

}

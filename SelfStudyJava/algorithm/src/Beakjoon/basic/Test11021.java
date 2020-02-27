package Beakjoon.basic;
/*
 * 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
 */
import java.util.*;

public class Test11021 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		for(int i=0;i<num;i++) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			if(num1>0 && num2<10) {
				System.out.println("Case #"+(i+1)+": "+(num1+num2));
			}
			
		}
		 sc.close();
	}

}

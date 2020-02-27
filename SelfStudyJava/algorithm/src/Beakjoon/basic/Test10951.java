package Beakjoon.basic;
//while을 이용해서 A+B 출력하기
/* 
 * 입력은 여러 개의 테스트 케이스로 이루어져 있다.
 * 이렇게 정상적인 프로그램 종료를 위해 데이터 소스로부터 더이상 읽을 수 있는 데이터가 없음을 나타내야 하는데,
 * 이를 파일 끝 (EOF)라고 한다. 
 * Java에서는 이 대 hasNext() 메서드를 이용한다. 
 */
import java.util.*;
public class Test10951 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
		if(num1>0&&num2<10) {
			System.out.println((num1+num2));
		}
		
		}
		sc.close();
	}
	
}

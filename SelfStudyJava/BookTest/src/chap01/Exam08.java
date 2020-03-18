package chap01;
import java.util.*;
//가우스의 덧셈
public class Exam08 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println("1부터 n까지의 합을 구합니다.");
		System.out.print("n의 값："+n);
		
		int sum = (n+1)*(n/2)+(n%2==1?(n+1)/2:0);
		System.out.println( );
		System.out.println(sum);
				
	}

}

package chap01;
import java.util.*;
public class Exam06 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int sum = 0; 		// гу
		for(int i =1;i<=n;i++) {
			if(i<n)
				System.out.println(i+"+");
			else
				System.out.println(i);
			sum+=i;
		}
		System.out.println("="+sum);
		
		

	}

}

package Test;
import java.util.Scanner;
public class BeakJoonTest01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[9];
		for (int i = 0; i <arr.length; i++) {
			arr[i] = sc.nextInt();
		}
			int max = arr[0]; // 기준이 될 첫번 째 값을 max에 넣음 
			int count = 0;	  // 최대값 위치 count 할 변수 생성 	
			for (int i = 1; i <arr.length; i++) {  // 비교는 다음 수 부터
				if (arr[i]>max) {
					max = arr[i];
					count=i+1;
				}
				
			}
			
		
		sc.close();
		
		System.out.println(max);
		System.out.println(count);
	

	}

}

package Test;
import java.util.Scanner;
public class BeakJoonTest01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[9];
		for (int i = 0; i <arr.length; i++) {
			arr[i] = sc.nextInt();
		}
			int max = arr[0]; // ������ �� ù�� ° ���� max�� ���� 
			int count = 0;	  // �ִ밪 ��ġ count �� ���� ���� 	
			for (int i = 1; i <arr.length; i++) {  // �񱳴� ���� �� ����
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

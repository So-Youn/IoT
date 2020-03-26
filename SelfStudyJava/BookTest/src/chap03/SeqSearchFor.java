package chap03;

import java.util.Scanner;

public class SeqSearchFor {
	// 배열 a의 앞쪽 n개의 요소에서 key와 같은 요소를 선형 검색 
	static int seqSearch(int[] a,int n, int key) {
		for (int i = 0; i < n; i++) 
			if (a[i] == key) 
				return i;
			
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("요솟 수 : ");
		
		int num = sc.nextInt();
		int[] x = new int[num];
		
		for (int i = 0; i < num ; i++) {
			System.out.print("x[" + i + "]：");
			x[i] = sc.nextInt();
		}
		
		System.out.println("찿는 값 :");
		int ky = sc.nextInt();
		
		int idx = seqSearch(x,num,ky);
		
		if (idx == -1)
			System.out.println("그 값의 요소가 없습니다.");
		else
			System.out.println("그 값은 x[" + idx + "]에 있습니다.");
	}
	
}

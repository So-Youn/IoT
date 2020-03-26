package chap03;

import java.util.Scanner;

public class SeqSearchEx {
	static int seqSearchEx(int[] a,int n,int key) {
		System.out.print("   |");
		for (int k = 0; k < n; k++) 
			System.out.print(k+"\t");
		System.out.println();
		
		System.out.print("---+");
		for(int k=0;k<4*n+2;k++)
			System.out.print("-");
		System.out.println();
		for (int i = 0; i < n; i++) {
			System.out.print("   |");
			System.out.printf(String.format("%%%ds*\n", (i * 4) + 3), "");
			System.out.printf("%3d|", i);
			for (int k = 0; k < n; k++)
				System.out.printf("%4d", a[k]);
			System.out.println("\n   |");
			if (a[i] == key)
				return i; // 검색성공
		}
		return -1; // 검색실패
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("요솟 수 : ");
		int num = sc.nextInt();
		int[] x = new int[num];
		for(int i=0;i<num;i++) {
			System.out.println("x["+i+"]:");
			x[i]=sc.nextInt();
		}
		
		System.out.println("찾는 값:");
		int key =sc.nextInt();
		
		int index = seqSearchEx(x,num,key);
		// 배열 x에서 값이 ky인 요소를 검색
		
		if(index == -1)
			System.out.println(" 그 값의 요소가 없다.");
		else
			System.out.println(key+"은"+"x["+index+"]에 있다.");
	}
}

package chap01;

import java.util.Scanner;

public class Triangle_Series {

	static void triangleLB(int n) {
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=i;j++)
				System.out.print('*');
			System.out.println();
		}
		
	}
	
	static void triangleLU(int n) {
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n-i+1;j++)
				System.out.print('*');
			System.out.println(); 
		}
		
	}
	
	static void triangleRU(int n) {
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=i-1;j++)
				System.out.print(" ");
			for(int j=1;j<=n-i+1;j++)
				System.out.print("*");
			System.out.println( );
		}
	}
	
	static void triangleRB(int n) {
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n-i;j++)
				System.out.print(" ");
			for(int j=1;j<=i;j++)
				System.out.print("*");
			System.out.println( );
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		
		System.out.println("삼각형 모양으로 나타냅니다.");
		
		do {
			System.out.println("단수는 :");
			n = sc.nextInt();
		}while(n<=0);
		
		System.out.println("왼쪽 아래가 직각인 삼각형");
		triangleLB(n);
		
		System.out.println("왼쪽 위가 직각인 삼각형");
		triangleLU(n);
		
		System.out.println("오른쪽 위가 직각인 삼각형");
		triangleRU(n); // 오른쪽 위가 직각인 이등변삼각형
		
		System.out.println("오른쪽 아래가 직각인 삼각형");
		triangleRB(n); // 오른쪽 아래가 직각인 이등변삼각형
		
	}

	

}

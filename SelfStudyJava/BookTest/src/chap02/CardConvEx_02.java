package chap02;
// 입력 받은 10진수를 2진수~36진수로 기수변환하여 출력(변환과정)
import java.util.*;
public class CardConvEx_02 {
	// 정수 x를 r진수로 변환하여 배열 d에 아랫자리부터 저장하고 자릿수를 반환
	static int cardConvEx(int x,int r,char[] d) {
		int n = ((Integer)x).toString().length();
		int digits = 0; //변환 뒤의 자릿 수
		String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		System.out.printf(String.format("%%2d | %%%dd\n",n),r,x);
		do {
			System.out.printf("   +");
			for(int i=0;i<n+2;i++)
				System.out.print('-');
			System.out.println();
			if (x / r != 0)
				System.out.printf(String.format("%%2d | %%%dd    … %%d\n", n), r, x / r, x % r);
			else
				System.out.printf(String.format("     %%%dd    … %%d\n", n), x / r, x % r);
			d[digits++] = dchar.charAt(x % r); // r로 나눈 나머지를 저장
			x /= r;
		}while(x!=0);
		for(int i=0; i<digits/2;i++) {
			char temp = d[i];
			d[i] = d[digits - i -1];
			d[digits - i -1] = temp;
		}
		return digits;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int no ; //변환하고자 하는 정수
 		int cd ;  //기수
 		int dno; // 변환 뒤의 자릿 수 
 		int retry; // 한번 더?
 		char[] cno = new char[32]; // 변환 뒤의 각 자리를 저장하는 문자 배열
 		
 		System.out.println("10진수의 기수 변환");
 		do {
 			do {
 				System.out.print("음아 아닌 정수 :");
 				no = sc.nextInt();
 			}while(no <0);
 			
 			do {
 				System.out.print(" 몇 진수로 변환 ? (2~36)");
 				cd = sc.nextInt();
 			} while(cd <2||cd>36);
 			
 			dno = cardConvEx(no, cd, cno); // no를 cd 진수로 변환
 			
 			System.out.print(cd + "진수로는");
 			
 			for(int i=0;i<dno;i++)
 				System.out.print(cno[i]);
 			System.out.println("입니다. ");
 			
 			System.out.print("한번 더 할까요 ? ( 1.예/ 0. 아니오)");
 			retry = sc.nextInt();
 		} while(retry==1);
	}

}

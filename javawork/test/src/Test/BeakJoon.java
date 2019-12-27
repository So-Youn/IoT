package Test;

import java.util.Scanner;

public class BeakJoon {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int num = sc.nextInt();
	int a =0;		//첫번째 자리 수
	int b =0;		//두번째 자리 수
	int temp=0;		//두번째 자리 수 임시 저장
	int cycle = 0;	//사이클 길이
	
	a = num/10;	
	b = num%10;
	
	while(true) {
		cycle++;
		temp = b;
		b = (a + b)%10;	//두번째 숫자는 합의 가장 오른쪽 자리 숫자.
		a = temp;		// 첫번째 숫자는 두번째 숫자.
		if (num == a*10+b) {  //이어붙이기
			break;
		}
	}
	System.out.println(cycle);
	sc.close();
	}

}

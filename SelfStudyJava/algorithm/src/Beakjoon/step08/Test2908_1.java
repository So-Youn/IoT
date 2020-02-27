package Beakjoon.step08;
import java.util.*;
//숫자 뒤집어서 대소 비교하기
public class Test2908_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		String str2 = sc.next();
		
		String temp = "";
		for (int i=str1.length()-1;i>=0;i--) {
			temp +=str1.charAt(i);
		}str1 = temp;
		temp = "";
		for (int i=str2.length()-1;i>=0;i--) {
			temp+=str2.charAt(i);
		}str2 = temp;
		
		int num1 = Integer.parseInt(str1);
		int num2 = Integer.parseInt(str2);
		
		if(num1>num2) {
			System.out.println(num1);
		}else {
			System.out.println(num2);
		}
			
	}

}

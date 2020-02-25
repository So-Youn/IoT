package Beakjoon.step08;

import java.util.Scanner;
//알파벳 소문자, 대문자, 숫자 0-9중 하나가 주어졌을 때, 
//주어진 글자의 아스키 코드값을 출력하는 프로그램을 작성하시오.
public class Test11654 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String num = sc.next();
		
		int charnum = num.charAt(0); //입력 받은 값을 char-> int 형으로 변형
		//charAt() : Returns the char value at the specified index.
		System.out.println(charnum);
	}

}

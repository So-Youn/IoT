package chap08;

import java.util.InputMismatchException;
import java.util.Scanner;
//ArrayIndexOutOfBoundsException => 배열의 요소를 잘못 액세스 했습니다.
//NullPointException => 널입니다
//나머지 => 오류발생 ! 

public class ExceptionTest04 {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		try {
		System.out.println("배열의 요소 갯수를 입력하세요");
		int size = key.nextInt();
		String[] arr = new String[size];
		System.out.println("step01");
		//System.out.println(arr[0].length());
		if (size > 3) {
			arr[1] = new String("java");
		}
		System.out.println(arr[1].length());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("배열의 요소를 잘못 액세스");
		} catch (NullPointerException e) {
			System.out.println("Null 입니다");
		} catch (Exception e) {// 모든 예외클래스의 상위클래스
			System.out.println("오류 발생!");
		}
	}
}

		
package chap08;

import java.util.InputMismatchException;
import java.util.Scanner;
//ArrayIndexOutOfBoundsException => �迭�� ��Ҹ� �߸� �׼��� �߽��ϴ�.
//NullPointException => ���Դϴ�
//������ => �����߻� ! 

public class ExceptionTest04 {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		try {
		System.out.println("�迭�� ��� ������ �Է��ϼ���");
		int size = key.nextInt();
		String[] arr = new String[size];
		System.out.println("step01");
		//System.out.println(arr[0].length());
		if (size > 3) {
			arr[1] = new String("java");
		}
		System.out.println(arr[1].length());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("�迭�� ��Ҹ� �߸� �׼���");
		} catch (NullPointerException e) {
			System.out.println("Null �Դϴ�");
		} catch (Exception e) {// ��� ����Ŭ������ ����Ŭ����
			System.out.println("���� �߻�!");
		}
	}
}

		
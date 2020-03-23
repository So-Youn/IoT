package chap02;

import java.util.Scanner;

public class ReverseArray {
	// �迭 ��� a[idx1]�� a[idx2]�� ���� �ٲ�
	static void swap(int[] a, int index1, int index2) {
		int t = a[index1];
		a[index1] = a[index2];
		a[index2] =t;
	}
	// �迭 a�� ��Ҹ� �������� ����
	static void reverse(int[] a) {
		for(int i=0;i<a.length/2;i++)
			swap(a,i,a.length-i-1);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("��ڼ� ��");
		int num = sc.nextInt();		// ��ڼ�
		int[] x = new int[num];
		
		for (int i = 0; i < num; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = sc.nextInt();
		}
		
		reverse(x);
		
		System.out.println("��Ҹ� �������� �����߽��ϴ�.");
		for (int i = 0; i < num; i++)
			System.out.println("x[" + i + "] = " + x[i]);
	}

}
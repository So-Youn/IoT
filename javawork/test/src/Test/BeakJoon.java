package Test;

import java.util.Scanner;

public class BeakJoon {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int num = sc.nextInt();
	int a =0;		//ù��° �ڸ� ��
	int b =0;		//�ι�° �ڸ� ��
	int temp=0;		//�ι�° �ڸ� �� �ӽ� ����
	int cycle = 0;	//����Ŭ ����
	
	a = num/10;	
	b = num%10;
	
	while(true) {
		cycle++;
		temp = b;
		b = (a + b)%10;	//�ι�° ���ڴ� ���� ���� ������ �ڸ� ����.
		a = temp;		// ù��° ���ڴ� �ι�° ����.
		if (num == a*10+b) {  //�̾���̱�
			break;
		}
	}
	System.out.println(cycle);
	sc.close();
	}

}

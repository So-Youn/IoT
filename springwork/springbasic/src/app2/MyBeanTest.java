package app2;

import app3.MyBeanStyleA;
import app3.MyBeanStyleB;

/*
 * OOP�� ����Ǿ� �ִ� ���α׷�  
 * OOPƯ���� �����ϱ� ���ؼ� ���� Ŭ������ �����ϰ� MyBeanStyleXXXŬ������ ����ϴ� �Ű������� Ÿ���� ���� Ÿ������ �����ϸ� �������� �����ߴ�.
 * ���Ǵ� ��ü�� ����Ǵ��� �ڵ带 �����ϴ� ������ �پ���.
 * �׷��� ���� ��ü�� �����ϴ� �������� �����ؼ� �����ϰ� �ִ�.
 * ����ϴ� ��ü�� �ٲ� ������ ��ü�� ���� �����ϴ� �ڵ带 ��� �����ؾ� �Ѵٴ� ������ �����Ѵ�.
 * ����ϴ� ������ ���� new�ؼ� ��ü�� �����ϴ� �ڵ�� �������� �ϴ� �ڵ��̴�.
 */
public class MyBeanTest {
	public static void main(String[] args) {
		MyBeanStyleB obj = new MyBeanStyleB();
		MyBeanStyleA obj2 = new MyBeanStyleA();
		run(obj);
		show(obj);
		run(obj2);
		show(obj2);
		
	}

	public static void run(MyBeanStyle obj) {
		System.out.println("****************************");
		obj.Hello("����");
		obj.Hello("����");
		System.out.println("============================");
	}
	public static void show(MyBeanStyle obj) {
		System.out.println("****************************");
		obj.Hello("����");
		obj.Hello("����");
		System.out.println("============================");
	}
}

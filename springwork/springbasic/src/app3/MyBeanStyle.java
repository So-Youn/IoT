package app3;

public abstract class MyBeanStyle {

	public abstract void Hello(String string);
	//��ü�� ������ �� �� �� ȣ��Ǵ� �޼ҵ�
	public void myInit() {
		System.out.println("init....");
	}
	//��ü�� �Ҹ�� �� �� �� ȣ��Ǵ� �޼ҵ�
	public void myDestroy() {
		System.out.println("myDestroy....");
	}
}

package app3;

import org.springframework.context.ApplicationContext; //����
import org.springframework.context.support.GenericXmlApplicationContext;

/*ApplicationContext�� ��ü�� �����ϴ� ���
 *  �̸� �� ����� ���� �ϳ������� ��� servletó�� ����Ѵ�.*/
 
public class MyBeanTest_ApplicationContext {
	public static void main(String[] args) {
		System.out.println("ApplicationContext ���� ��");
		ApplicationContext factory = new GenericXmlApplicationContext("/config/bean.xml");
		System.out.println("getBean ȣ�� ��");
		MyBeanStyle obj = (MyBeanStyle)factory.getBean("myBean1"); 
			
		//����Ͻ� ���� ȣ��
		
		run(obj);
		show(obj);
		
		
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
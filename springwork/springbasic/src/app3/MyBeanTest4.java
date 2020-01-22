package app3;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/*
 * BeanFactory ����ؼ� �۾��ϱ�
 * 1. xml�� spring���� ����� �� �ֵ��� ��ü�� ��ȯ�ϴ� �۾��� �����ϴ� ��ü ����
 *  ->ClassPathResource�� xml������ classpath(src)���� ã�´�. 
 *  ->������ src��� ���ص� �ȴ�.
 * 2. �����̳� ��ü�� ����
 */
public class MyBeanTest4 {
	public static void main(String[] args) {
		//ApplicationContext���� ����� �� ����.
		AbstractApplicationContext factory = new GenericXmlApplicationContext("/config/bean.xml");
		//�⺻ ������ singleton�̹Ƿ� getBean�� �� �� ȣ���ص�
		//MyBeanStyleB��ü�� �� ���� �����Ǿ� ȣ��ȴ�.
		//���� init�� �� �� ȣ��ȴ�.
		MyBeanStyle obj1 = (MyBeanStyle)factory.getBean("myBean2"); 
		MyBeanStyle obj2 = (MyBeanStyle)factory.getBean("myBean2"); //getBean �� ���� ã�ƴ޶�� �ǹ�	
		MyBeanStyle obj3 = (MyBeanStyle)factory.getBean("myBean2");
		
		run(obj1);
		show(obj1);
		//�����̳ʿ� ���� ������ ��ü�� �Ҹ�Ǵ� ������ �����̳ʰ� �Ҹ�� �� 
		factory.close();	//�������� lifecycle�� ����� �� �� �� �����ؾ� �ϴ� �޼ҵ�.
		
		
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

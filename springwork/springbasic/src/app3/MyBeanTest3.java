package app3;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/*
 * BeanFactory ����ؼ� �۾��ϱ�
 * 1. xml�� spring���� ����� �� �ֵ��� ��ü�� ��ȯ�ϴ� �۾��� �����ϴ� ��ü ����
 *  ->ClassPathResource�� xml������ classpath(src)���� ã�´�. 
 *  ->������ src��� ���ص� �ȴ�.
 * 2. �����̳� ��ü�� ����
 */
public class MyBeanTest3 {
	public static void main(String[] args) {
		Resource res = new ClassPathResource("/config/bean.xml");
		BeanFactory factory = new XmlBeanFactory(res); //The type XmlBeanFactory is deprecated
		MyBeanStyle obj1 = (MyBeanStyle)factory.getBean("myBean1"); 
		MyBeanStyle obj2 = (MyBeanStyle)factory.getBean("myBean1"); //getBean �� ���� ã�ƴ޶�� �ǹ�	
		//����Ͻ� ���� ȣ��
		if (obj1==obj2) {
			System.out.println("����.");
		}else {
			System.out.println("�ٸ���");
		}
		run(obj1);
		show(obj1);
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

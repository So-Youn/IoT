package app3;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

//BeanFactory(�����̳�)�� ��ü�� �����ϴ� ���. - ���� ��ü�� �����ұ�? ��û�� �� �� �����
	public class MyBeanTest_BeanFactory{
	public static void main(String[] args) {
		System.out.println("*******resource ���� �� **********");
		Resource res = new ClassPathResource("/config/bean.xml");
		System.out.println("****BeanFactory ���� �� **********");
		BeanFactory factory = new XmlBeanFactory(res); //The type XmlBeanFactory is deprecated
		System.out.println("******getBean ���� �� **********");
		MyBeanStyle obj = (MyBeanStyle)factory.getBean("myBean1"); 
		MyBeanStyle obj2 = (MyBeanStyle)factory.getBean("myBean1"); //getBean�� singleton���� �Ȱ��� ��ü �Ѱ��� ���� �����Ѵ�.
		//����Ͻ� ���� ȣ��
		if (obj==obj2) {
			System.out.println("����.");
		}else {
			System.out.println("�ٸ���");
		}	
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

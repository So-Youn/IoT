package app3;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/*
 * BeanFactory 사용해서 작업하기
 * 1. xml을 spring에서 사용할 수 있도록 객체로 변환하는 작업을 수행하는 객체 생성
 *  ->ClassPathResource는 xml문서를 classpath(src)에서 찾는다. 
 *  ->때문에 src명시 안해도 된다.
 * 2. 컨테이너 객체를 생성
 */
public class MyBeanTest4 {
	public static void main(String[] args) {
		//ApplicationContext보다 기능이 더 많다.
		AbstractApplicationContext factory = new GenericXmlApplicationContext("/config/bean.xml");
		//기본 설정이 singleton이므로 getBean을 세 번 호출해도
		//MyBeanStyleB객체는 한 개만 생성되어 호출된다.
		//따라서 init도 한 번 호출된다.
		MyBeanStyle obj1 = (MyBeanStyle)factory.getBean("myBean2"); 
		MyBeanStyle obj2 = (MyBeanStyle)factory.getBean("myBean2"); //getBean 은 그저 찾아달라는 의미	
		MyBeanStyle obj3 = (MyBeanStyle)factory.getBean("myBean2");
		
		run(obj1);
		show(obj1);
		//컨테이너에 의해 생성된 객체가 소멸되는 시점은 컨테이너가 소멸될 때 
		factory.close();	//서블릿같은 lifecycle을 만들어 줄 때 꼭 생성해야 하는 메소드.
		
		
	}

	public static void run(MyBeanStyle obj) {
		System.out.println("****************************");
		obj.Hello("현빈");
		obj.Hello("현빈");
		System.out.println("============================");
	}
	public static void show(MyBeanStyle obj) {
		System.out.println("****************************");
		obj.Hello("현빈");
		obj.Hello("현빈");
		System.out.println("============================");
	}
}

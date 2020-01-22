package app3;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

//BeanFactory(컨테이너)가 객체를 관리하는 방법. - 언제 객체를 생성할까? 요청을 할 때 만든다
	public class MyBeanTest_BeanFactory{
	public static void main(String[] args) {
		System.out.println("*******resource 생성 전 **********");
		Resource res = new ClassPathResource("/config/bean.xml");
		System.out.println("****BeanFactory 생성 전 **********");
		BeanFactory factory = new XmlBeanFactory(res); //The type XmlBeanFactory is deprecated
		System.out.println("******getBean 생성 전 **********");
		MyBeanStyle obj = (MyBeanStyle)factory.getBean("myBean1"); 
		MyBeanStyle obj2 = (MyBeanStyle)factory.getBean("myBean1"); //getBean은 singleton으로 똑같은 객체 한개만 만들어서 관리한다.
		//비즈니스 로직 호출
		if (obj==obj2) {
			System.out.println("같다.");
		}else {
			System.out.println("다르다");
		}	
		//비즈니스 로직 호출
		
		run(obj);
		show(obj);
		
		
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

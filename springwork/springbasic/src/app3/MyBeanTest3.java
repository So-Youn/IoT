package app3;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/*
 * BeanFactory 사용해서 작업하기
 * 1. xml을 spring에서 사용할 수 있도록 객체로 변환하는 작업을 수행하는 객체 생성
 *  ->ClassPathResource는 xml문서를 classpath(src)에서 찾는다. 
 *  ->때문에 src명시 안해도 된다.
 * 2. 컨테이너 객체를 생성
 */
public class MyBeanTest3 {
	public static void main(String[] args) {
		Resource res = new ClassPathResource("/config/bean.xml");
		BeanFactory factory = new XmlBeanFactory(res); //The type XmlBeanFactory is deprecated
		MyBeanStyle obj1 = (MyBeanStyle)factory.getBean("myBean1"); 
		MyBeanStyle obj2 = (MyBeanStyle)factory.getBean("myBean1"); //getBean 은 그저 찾아달라는 의미	
		//비즈니스 로직 호출
		if (obj1==obj2) {
			System.out.println("같다.");
		}else {
			System.out.println("다르다");
		}
		run(obj1);
		show(obj1);
		run(obj2);
		show(obj2);
		
		
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

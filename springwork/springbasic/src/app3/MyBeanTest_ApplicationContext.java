package app3;

import org.springframework.context.ApplicationContext; //상위
import org.springframework.context.support.GenericXmlApplicationContext;

/*ApplicationContext가 객체를 관리하는 방법
 *  미리 다 만들어 놓고 하나가지고 계속 servlet처럼 사용한다.*/
 
public class MyBeanTest_ApplicationContext {
	public static void main(String[] args) {
		System.out.println("ApplicationContext 생성 전");
		ApplicationContext factory = new GenericXmlApplicationContext("/config/bean.xml");
		System.out.println("getBean 호출 전");
		MyBeanStyle obj = (MyBeanStyle)factory.getBean("myBean1"); 
			
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

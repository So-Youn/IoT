package dl.exam01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {
	public static void main(String[] args) {
		//스크링 컨테이너에 의해 생성해서 객체를 전달 받아 사용할 수 있도록 수정하기
		//Dependency Lookup 적용
		//설정 파일 : config/bean.xml
		//빈 등록 : 
		// SamsungTV = > samsung
		// Lgtv => lg
		//getBean으로 얻어와서 작업하도록 코드 수정하기 
		AbstractApplicationContext factory = new GenericXmlApplicationContext("config/bean.xml");
		TV tv = factory.getBean("tv",TV.class);	//캐스팅을 TV.class로 TV타입임을 명시한다.
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		
	}

}

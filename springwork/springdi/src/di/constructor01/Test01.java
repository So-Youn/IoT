package di.constructor01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Test01 {
	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("config/bean.xml");
		AbstractPlayer p = factory.getBean("player",AbstractPlayer.class);
		//player가 한두개가 아닐 수도 있으니 타입을 Abstract타입으로 정의.
		p.play();
		System.out.println("세번 굴린 주사위의 합:"+p.getTotalValue());
	}

}

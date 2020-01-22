package dl.exam01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {
	public static void main(String[] args) {
		//��ũ�� �����̳ʿ� ���� �����ؼ� ��ü�� ���� �޾� ����� �� �ֵ��� �����ϱ�
		//Dependency Lookup ����
		//���� ���� : config/bean.xml
		//�� ��� : 
		// SamsungTV = > samsung
		// Lgtv => lg
		//getBean���� ���ͼ� �۾��ϵ��� �ڵ� �����ϱ� 
		AbstractApplicationContext factory = new GenericXmlApplicationContext("config/bean.xml");
		TV tv = factory.getBean("tv",TV.class);	//ĳ������ TV.class�� TVŸ������ ����Ѵ�.
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		
	}

}

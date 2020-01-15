package api.util;

import java.util.HashSet;
import java.util.Iterator;

//����, �ߺ��� ������� �ʴ´�.
public class HashSetTest {
	public static void main(String[] args) {
		HashSet<String> set = new HashSet<String>();
		set.add("java");
		set.add("jdbc");
		set.add("oracle");
		set.add("html");
		set.add("css");
		set.add("java");
		System.out.println("������ =>" +set.size());
		
		//set�� ����� ��Ҹ� ����
		/*1.HashSet �����͸� ǥ�� �������̽� ( ��� �ڷᱸ���� ��� �����͸� ��ȯ�ؼ� ���� �� �ֵ��� �����Ǵ� �������� �������̽� )
		 * �� Iterator�� ��ȯ*/
		Iterator<String> it = set.iterator();
		//2.��ȯ�� �� ����
		while(it.hasNext()) {//Iterator�ȿ� �����Ұ� �ִ����� Ȯ�� - boolean ����
			String data = it.next(); //Iterator�� ����� ��Ҹ� �ϳ��� ������ ��ȯ
			System.out.println("���� ��� :"+ data);
			//������� ��ȯ���� �ʴ´�
		}
		for(String data:set) {
			System.out.println("set�� ����� ���:"+data);
		}
	}

}
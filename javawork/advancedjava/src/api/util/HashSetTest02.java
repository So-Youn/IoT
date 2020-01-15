package api.util;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest02 {
	public static void main(String[] args) {
		HashSet<String> set = new HashSet<String>();
		set.add("java");
		set.add("jdbc");
		set.add("oracle");
		set.add("html");
		set.add("css");
		set.add("java");
		print(set,"set");
		
		/*합집합을 구현하는 방법은 =>Set객체를 생성할 때 합집합으로 표현할 Set을 생성자의 매개변수로 전달*/
		HashSet<String> set2 = new HashSet<String>(set);
		set2.add("servlet");
		set2.add("jsp");
		set2.add("hadoop");
		print(set2,"set2");
		
		HashSet<String> set3 = new HashSet<String>();
		set3.add("java");
		set3.add("jdbc");
		set3.add("oracle");
		set3.add("hive");
		print(set3,"set3");
		
		//set과 set3의 교집합 구하기 - for문을 돌려서 일일이 비교하지 않기 위해
		//set과 set3에 저장된 요소 중 중복되는 요소만 가지고 새로운 set구조를 만든다
		//set과 set3을 비교해서 일치하는 것만 남기고 나머지는 제거된다.
		set.retainAll(set3);
		
		print(set,"교집합");
		
	}
	public static void print(Set<String> set, String setName) {	//다형성을 위해 Set<E>
		System.out.println("사이즈=>" + set.size());
		for (String data : set) {
			System.out.println(setName+"에 저장된 요소=>"+data);
		}
		System.out.println("=============================");
	}
}

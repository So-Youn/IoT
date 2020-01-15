package api.util;

import java.util.HashSet;
import java.util.Set;

public class HashSetExam {
	public static void main(String[] args) {
		HashSet<Integer> set1 = new HashSet<Integer>();
		for (int i = 0; i <=10; i++) {
			set1.add(i);
		}
		System.out.println(set1);
	
		HashSet<Integer> set2 = new HashSet<Integer>();
		for (int i = 5; i <=15; i++) {
			set2.add(i);
		}
		System.out.println(set2);
		System.out.println("==========================");
		
		HashSet<Integer> set3 = new HashSet<Integer>(set1);
		set3.addAll(set2);
		print(set3,"합집합");
		
		HashSet<Integer> set4 = new HashSet<Integer>(set1);
		set4.retainAll(set2);
		print(set4,"교집합");
	}
	public static void print(HashSet<Integer> set, String setName) {	//다형성을 위해 Set<E>
		for (Integer data : set) {
			System.out.println(setName+"에 저장된 요소=>"+data);
		}
		System.out.println("=============================");
	}
}

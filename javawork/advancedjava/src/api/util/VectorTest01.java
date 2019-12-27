package api.util;

import java.util.Vector;

public class VectorTest01 {

	public static void main(String[] args) {
		Vector<Integer> v = new Vector<Integer>();//Vector<데이터타입>
		v.add(10);
		
		
		System.out.println("Vector의 용량 : "+v.capacity()); //총 사이즈
		System.out.println("Vector의 용량 : "+v.size());
		//api는 method call로 접근해야한다.
		System.out.println();
		System.out.println("=============================");
		for(int i =0;i<10;i++) {
			v.add(i);
		}
		
		System.out.println("Vector의 용량 : "+v.capacity()); //총 사이즈
		System.out.println("Vector의 용량 : "+v.size());
		//api는 method call로 접근해야한다.
		System.out.println();
		System.out.println("=============================");
		for(int i =0;i<10;i++) {
			v.add(i);
		}
		
	}

}

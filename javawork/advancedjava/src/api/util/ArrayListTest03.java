package api.util;

import java.util.ArrayList;

public class ArrayListTest03 {

	public static void main(String[] args) {
		String[] arr = {"java", "oracle","jdbc","htmls", "css","java"};
		ArrayList<String> list = changeData(arr);
		for(String data : list) {
			System.out.println("요소 :"+data);
		}
		System.out.println("========================================");
		//for 문을 돌 때마다 list.size()를 call한다. 
		int size = list.size(); //size를 변수화하면서 resource를 줄일 수 있다.
		for (int i = 0; i<size ; i++) {
			System.out.println("요소 : "+list.get(i));
		}
		//중복된 데이터여도 저장된 데이터 전부 출력 가능하다.
		
				
	}
	public static ArrayList<String> changeData(String[] arr){
		ArrayList<String> list = new ArrayList<String>();
		
		for(int i=0;i<arr.length;i++) {
			list.add(arr[i]);
		}
		return list;
	}
}

package api.util;

import java.util.ArrayList;

public class ArrayListTest02 {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("자바");
		list.add("오라클");
		for(int i = 0 ; i< list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}

package Chap04;

public class SwitchTest01 {

	public static void main(String[] args) {
		double d = 1.5;
		int data = 5;
		switch(data+60) {
		case 'A' :
			System.out.println("A");
			break;
		case 'B' :
		System.out.println("B");
			break;
		}
		String code = new String("a01");
		switch(code) {
		case "a01" :
			System.out.println("A01");
			break;
		case "a02" :
			System.out.println("A02");
		}

	}

}

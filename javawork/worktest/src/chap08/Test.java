package chap08;

public class Test {
	public static void main(String[] args) {
		ThrowsTest01 obj = new ThrowsTest01();
		int num = obj.test(100, 0);
		System.out.println("°á°ú : " + num);

		ThrowsTest02 obj2 = new ThrowsTest02();
	
		int num2 = 0;
		int inputNum = 100;
		try {
			num2 = obj.test(100, 0);
		} catch (ArithmeticException e) {
			// Â¦¼ö¸é 100000 È¦¼ö¸é 0
			if (inputNum % 2 == 0) {
				num2 = 100000;
			} else {
				num2 = 0;
			}
		}
		num2 = obj2.test(100, 0);
	}
}

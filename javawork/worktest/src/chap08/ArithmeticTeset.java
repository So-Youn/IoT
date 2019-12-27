package chap08;

public class ArithmeticTeset {
	public static void main(String[] args) {
		int number = 100;
		int result = 0;
		for (int i = 0; i < 10; i++) {
			try {
				result = number / (int) (Math.random() * 10);
				System.out.println(result);
			} catch (ArithmeticException e) { //ArithmeticException 발생시 catch문 실행 후, 다시 for문의 다음 반복 진행.
				System.out.println("0");
			} // try-catch의 끝
		}
	}

}

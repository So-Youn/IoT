package workbook.poly;

public class Test01 {
	public static void main(String[] args) {
		int data = Integer.parseInt(args[0]);
		Calc calc = new Calc(); // 객체 생성
		Calc.calculate(data);

	}

}

class Calc {
	public static void calculate(int data) {
		int sum = 0;

		if (data < 5 & data > 10) {
			System.out.println("다시 입력하세요");
		} else {
			for (int i = 0; i <= data; i++) {
				if (i % 2 == 0) {
					sum = sum + i;

				}
			}System.out.println(sum);
		} 
	}
}

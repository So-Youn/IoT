package chap08;

public class CalcTest {
	public static void main(String[] args) { // String으로 받음...-> .equals()
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[2]);
		
		Calculator calc = new Calculator();
		// args.length == 3 일때 ~
		
		if (args.length == 3) {
			if (args[1].equals("+")) {
				calc.plus(a, b);
			} else if (args[1].equals("-")) {
				calc.minus(a, b);
			} else if (args[1].equals("*")) {
				calc.multiple(a, b);
			} else if (args[1].equals("/")) {
				calc.divide(a, b);
			}
			calc.print();
			//static은 그냥 부를 수 있기 때문에 Calculator. ~ 해도 되는데
			//일반 클래스 선언은 calc.~으로 호출하기!

		} else {
			System.out.println("다시 입력하세요");
		}
	}

}

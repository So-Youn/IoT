package workbook.poly;

public class CalcTest {
	public static void main(String[] args) {
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		char c = (char)Integer.parseInt(args[2]);
		Calculator calc = new Calculator();
		
		if (c == '+') {
			Calculator.plus(a,b);
		}else if(c == '-') {
			Calculator.minus(a,b);
		}else if(c == '*') {
			Calculator.multiple(a,b);
		}else if(c == '/') {
			Calculator.divide(a,b);
		}
	}

	

}

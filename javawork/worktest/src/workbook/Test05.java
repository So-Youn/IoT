package workbook;

public class Test05 {

	public static void main(String[] args) {
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		int c = Integer.parseInt(args[2]);
		int d = Integer.parseInt(args[3]);

		Calc calc = new Calc();
		int sum = calc.calcSum(a, b, c, d);

		double avg = (double) sum / args.length;
		System.out.println("sum=" + sum);
		System.out.println("avg=" + avg);

		if (avg > 100 | avg < 0) {
			System.out.println("잘못입력");
		} else {
			if (avg >= 90) {
				System.out.println("A");
			} else if (avg >= 70) {
				System.out.println("B");
			} else if (avg >= 50) {
				System.out.println("c");
			} else if (avg >= 30) {
				System.out.println("D");
			} else {
				System.out.println("F");
			}
		}

	}
}
package Chap04;

public class ForExam {
	public static void main(String[] args) {
		int sum = 0;
		int sum1 = 0;
		int sum2 = 0;// ÃÑÇÕ, Â¦¼öÇÕ, È¦¼öÇÕ
		for (int i = 1; i <= 100; i++) {
			sum = sum + i;
			if (i % 2 == 0) {
				sum1 = sum1 + i;
			} else {
				sum2 = sum2 + i;
			}
		}
			System.out.println("ÃÑÇÕ : " + sum);
			System.out.println("Â¦¼ö ÇÕ :" + sum1);
			System.out.println("È¦¼ö ÇÕ :" + sum2);
	}
}

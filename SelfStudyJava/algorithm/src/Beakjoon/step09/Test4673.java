package Beakjoon.step09;



//셀프넘버	
public class Test4673 {

	public static void main(String[] args) { // 메인

		boolean[] check = new boolean[10001]; // 1부터 10000이므로

		for (int i = 1; i < 100001; i++) {
			int n = d(i);
			
			if (n < 10001) { // 10000 이 넘는 수는 필요가 없음
				check[n] = true;
			}
		}
	
		// boolean 배열에서 false 인 원소의 위치(인덱스)를 출력
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= 10000; i++) {
			if (!check[i]) {// false 인 인덱스만 출력
				sb.append(i).append("\n");

			}
		}
		System.out.println(sb);
	}	

	public static int d(int number) { // 함수
		int sum = number;
		// number라는 수를 받으면 number를 생성자로 하는 수를 리턴 시킨다.
		while (number != 0) {
			sum = sum + (number % 10); // 첫 째 자리수
			number = number / 10; // 10을 나누어 첫 째 자리를 없앤다.
		}
		return sum;
	}
}

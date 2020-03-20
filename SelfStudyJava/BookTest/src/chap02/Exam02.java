package chap02;
//배열 b의 모든 요소를 배열 a에 역순으로 copy하는 메소드를 작성하세요.
import java.util.Scanner;

public class Exam02 {
		static void rcopy(int[] a,int[] b) {
			int num = a.length<= b.length? a.length : b.length;
			
			for (int i = 0; i <num; i++)
				a[i] = b[b.length - i -1];

		}
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.print("배열 a의 요솟수：");
		int na = stdIn.nextInt();		// 배열 a의 요솟수

		int[] a = new int[na];			// 요솟수가 na인 배열

		for (int i = 0; i < na; i++) {
			System.out.print("a[" + i + "] : ");
			a[i] = stdIn.nextInt();
		}

		System.out.print("배열 b의 요솟수：");
		int nb = stdIn.nextInt();		// 배열 b의 요솟수

		int[] b = new int[nb];			// 요솟수가 nb인 배열

		for (int i = 0; i < nb; i++) {
			System.out.print("b[" + i + "] : ");
			b[i] = stdIn.nextInt();
		}

		rcopy(a,b);
		System.out.println("배열 b의 모든 요소를 배열 a에 역순으로 복사했습니다.");
		for(int i = 0;i<na;i++)
			System.out.println("a[" + i + "] = " + a[i]);
	}

}

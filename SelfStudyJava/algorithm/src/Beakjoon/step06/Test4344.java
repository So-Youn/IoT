package Beakjoon.step06;
//평균이 넘는 학생들의 퍼센테이지를 출력하는 문제
import java.util.*;
public class Test4344 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        int n, total, count;
        double avg;
        int scores[] = new int[1000];
         
        for (int i = 0; i < c; i++) {
            n = sc.nextInt();
            total = 0;
            count = 0;
            for (int j = 0; j < n; j++) {
                scores[j] = sc.nextInt();
                total += scores[j];
            }
            avg = (double)total / n;
             
            for (int j = 0; j < n; j++) {
                if (scores[j] > avg) {
                    count++;
                }
            }
            System.out.printf("%.3f", 100.0 * count / n);
            System.out.println("%");
           //소수점 셋째 자리까지 출력
        }
        sc.close();
    }
}

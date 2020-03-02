package Beakjoon.step08;
import java.util.*;
public class Test1157 {
//가장 많이 사용된 알파벳 찾기.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] cnt = new int[26]; //알파벳 카운트 저장
		int max =0;  //가장 많이 나온 알파벳 수를 저장할 변수
		char answer = '?';
		
		String word = sc.next().toUpperCase();
		//단어 입력 + 대문자 변환
		for(int i=0;i<word.length();i++) {
			cnt[word.charAt(i)-65]++;  // 알파벳카운트 배열 index에 +1
			if(max < cnt[word.charAt(i)-65]) {
				answer = word.charAt(i); 
				max = cnt[word.charAt(i)-65];
			}
			else if(max == cnt[word.charAt(i)-65]) {
				answer ='?'; // 현재 알파벳 수가 max와 같다면
			}
		}
		System.out.println(answer);
		sc.close();
		
	}

}

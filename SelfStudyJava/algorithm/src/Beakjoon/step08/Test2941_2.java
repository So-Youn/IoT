package Beakjoon.step08;
//크로아티아 알파벳 출력
//Scanner 버전
import java.util.*;
public class Test2941_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] croatia = {"c=","c-","dz=","d-","lj","nj","s=","z="};
		
		String input = sc.nextLine();
		
		for(int i=0;i<8;i++) {
			input = input.replaceAll(croatia[i], "A");
	}
		System.out.println(input.length());
	}
}

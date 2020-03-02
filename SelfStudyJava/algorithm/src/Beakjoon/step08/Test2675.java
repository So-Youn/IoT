package Beakjoon.step08;
import java.util.*;
public class Test2675 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		for(int i=0;i<num;i++) {
			int cnt = sc.nextInt();
			String line = sc.nextLine();
			
			String result ="";
			for(int j=0;j<line.length();j++) {
				for(int k=0;k<cnt;k++){
					result+=line.charAt(j);
				}
			}
			result = result.replaceAll(" ", "");
			System.out.println(result);
		}
		sc.close();
	}

}

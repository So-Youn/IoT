package Beakjoon.step08;
import java.io.*;
import java.util.*;
//숫자 뒤집어서 대소 비교하기
public class Test2908 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer(br.readLine());
		StringTokenizer st = new StringTokenizer(sb.reverse().toString());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		bw.write(String.valueOf(Math.max(a, b)));
		bw.flush();
	}

}

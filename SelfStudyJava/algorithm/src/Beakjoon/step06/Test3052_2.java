package Beakjoon.step06;
//buffered »ç¿ë
import java.io.*;
public class Test3052_2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		boolean[] chk = new boolean[42];
		int cnt=0;
		for(int i=0;i<10;i++) {
			int a = Integer.parseInt(br.readLine().trim())%42;
			if (!chk[a]) {
				cnt++;
				chk[a] = true;
			}
		}
	System.out.println(cnt);
	}

}

package Beakjoon.basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Test15552 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int n = Integer.parseInt(br.readLine());
			if(n>1000000) {
				System.out.println("입력 값이 1,000,000이 넘었습니다");
				return;
			}
			for(int i=0;i<n;i++) {
				String[] word = br.readLine().split(" ");
				if(Integer.parseInt(word[0])<0 || Integer.parseInt(word[0])>1000
						|| Integer.parseInt(word[1])<0 ||Integer.parseInt(word[1])>1000) {
					System.out.println("더해지는 숫자는 0~1000까지의 숫자입니다");
					return;
				}
				bw.write(Integer.parseInt(word[0])+Integer.parseInt(word[1])+"\n");
			}
			bw.flush();
			bw.close();
		}catch(Exception e ) {
			e.printStackTrace();
		}
	}

}

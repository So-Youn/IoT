package Beakjoon.step09;
//StringTokenizer 이용...
import java.util.*;
import java.io.*;

public class Test1316_2 {
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //단어 갯수
        int groupWordCount = n; // 그룹단어 수
        
        for(int i=0;i<n;i++) {
        	st = new StringTokenizer(br.readLine());
        	String word = st.nextToken();
        	
        	int[] checkArray = new int[26];
        	checkArray[word.charAt(0)-97] =-1; //초기값 설정
        	
        	if(word.length()>1) {
        		for(int j=1;j<word.length();j++) {
        			if(checkArray[word.charAt(j)-97]== -1&&word.charAt(j)!=word.charAt(j-1)) {
        				// 한 번 나왔기도 했는데 앞의 알파벳과 다르면 그룹단어에서 탈락 
        				groupWordCount--;
        				break;
        			}
        			 checkArray[word.charAt(j) - 97] = -1; 
        			 // 해당 알파벳이 나오면 -1로 바꿈(나중에 체크할 시점에서 이미 한 번 나왔었다는 증거)
        		}
        	}
        }
        bw.write(String.valueOf(groupWordCount));
        bw.flush();
	}
}

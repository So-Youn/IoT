package api.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//항상 두 컬럼으로 고정
//[출력형태]
//이민호의 점수는 100점
//현빈의 점수는 98점
//김범룡의 점수는 99점
//총점 :____	
//평균 :____
public class ScoreTest {
	public static void main(String[] args) {
		BufferedReader br = null;
		int sum=0;
		int count=0;
		try {
			br = new BufferedReader(new FileReader("src/data/score.txt"));
			while (true) {
				String data = br.readLine();
				if (data == null) {
					break;
				}
				//null을 만나서 break되지 않도록 if문 밑에 쓴다.
				String[] newdata = data.split(",");
				System.out.println(newdata[0]+"의점수는"+newdata[1]);
				
				sum=sum+Integer.parseInt(newdata[1]);
				count++;
			}
			
			System.out.println("총점:"+sum);
			System.out.println("평균:"+sum/count);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 3.파일 닫기
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}

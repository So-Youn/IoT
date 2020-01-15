package api.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = null;
		try {
			// 1.파일 오픈하기
			// fr = new FileReader("src/data/test.txt"); //기본 스트림
			// br = new BufferedReader(fr); //보조 스트림 - 기본 스트림과 연결
			br = new BufferedReader(new FileReader("src/api/io/FileTest01.java"));
			int count = 0; // 실행 횟수 저장
			long start = System.nanoTime();
			// 2.파일 액세스
			while (true) {
				String data = br.readLine();
				if (data == null) {
					break;
				}
				count++;
				System.out.println(data);
			}
			long end = System.nanoTime();
			System.out.println("실행 횟수 =>" + count);
			System.out.println("실행 시간 =>" + (end - start));
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

package api.io;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class InputStreamReaderTest {
	// InputStream을 이용해서 키보드로 입력받는 문자열을 읽기
	// Scanner클래스의 next메소드의 기능을 구현
	public static void main(String[] args) {
		InputStreamReader in = new InputStreamReader(System.in);// System.in은 상수
		PrintStream out = System.out;
		while (true) {
			// 1. 스트림의 데이터를 1byte 읽는 작업
			try {

				int data = in.read();
				if (data == 13) {
					break;
				}
				out.print((char) data);

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

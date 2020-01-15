package api.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

//InputStream을 이용해서 키보드로 입력받는 문자열 읽기 - Scanner클래스의 next메소드의 기능 구현
//
public class InputStreamTest {
	public static void main(String[] args) {
		InputStream in = System.in; // System.in는 상수
		PrintStream out = System.out;
		// read메소드는 한번에 1byte밖에 읽지 못하므로 반복문을 돌려주어야 한다.
		while (true) {
			// 1. 스트림의 데이터를 1byte 읽는 작업
			try {
				int data = in.read();
				if (data == 13) {
					// 13번 ; enter의미
					break;
				}
				out.print((char) data);
				// 한글을 2byte이기 때문에 조합을 하지 못하여 읽지 못한다.
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}

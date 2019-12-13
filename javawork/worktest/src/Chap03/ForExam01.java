package Chap03;
//for A~Z까지 출력
public class ForExam01 {

	public static void main(String[] args) {
		for(int i = 65; i<=90; i++)
			System.out.println((char)i);
		System.out.println( );
		for(char data = 'A'; data<='Z';data++) {
			System.out.print(data);
		}
	}

}

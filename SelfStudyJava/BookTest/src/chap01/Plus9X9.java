package chap01;
//µ¡¼ÀÇ¥
public class Plus9X9 {
	public static void main(String[] args) {
		System.out.print("   |");
		for(int i=1;i<=9;i++)
			System.out.print(i+"\t");
		System.out.println("\n---+---------------------------------------------------------");
		for(int i=1;i<=9;i++) {
			System.out.print(i+" |");
			for(int j=1;j<=9;j++)
				System.out.print((i+j)+"\t");
			System.out.println( );
		}
			

	}

}

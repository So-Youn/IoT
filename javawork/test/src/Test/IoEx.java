package Test;

import java.util.Scanner;

public class IoEx{

	public static void main(String[] args) {
		Scanner A = new Scanner(System.in);
		int Ainput = A.nextInt();
		int Binput = A.nextInt();
		A.close();
		
		System.out.println(Ainput * (Binput %10));
		System.out.println(Ainput * ((Binput % 100)/ 10));
		System.out.println(Ainput * (Binput / 100));
		System.out.println(Ainput * Binput);
	}

}


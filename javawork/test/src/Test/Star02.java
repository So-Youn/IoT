package Test;

import java.util.Scanner;

public class Star02{
	public static void main(String[] args) {
		
		Scanner input =new Scanner(System.in);
		int N = input.nextInt();
		input.close();
		for (int i = 1; i <= N; ++i) {
            for (int j = 1; j <= N - i; ++j) {
                System.out.print(" ");
            }
             
            for (int j = 1; j <= i; ++j) {
                System.out.print("*");
            }
            System.out.println();
        }
			
		}
	}



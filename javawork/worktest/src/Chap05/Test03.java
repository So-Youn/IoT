package Chap05;

public class Test03 {
	public static void main(String[] args) {
		int[][] arr2 = {
				{5,5},
				{10,10,10,10,10},
				{20,20,20},
				{30,30,30,30}
				};
		int sum =0;
		int count = 0;
		for (int j=0;j<arr2.length;j++) {
			for(int i=0; i<arr2[j].length;i++) {
				System.out.print(arr2[j][i]+"\t");
			sum = sum +arr2[j][i];
			count++;
			}
			System.out.println( );
		}
			System.out.println("sum=>"+sum);
			System.out.println("avg=>"+(double)sum/count);
	}

}

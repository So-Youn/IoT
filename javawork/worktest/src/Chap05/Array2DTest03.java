package Chap05;
//2차원배열의 선언과 생성과 초기화하기
public class Array2DTest03 {
	public static void main(String[] args) {
		int[][] myarr = {
				{1,2,3,4,5},
				{6,7,8,9,10},
				{11,12,13,14,15},
				};	//int[][] myarr = new int[3][5]
		int[][] myarr2 = {
				{1,2,3},
				{6,7,8,9},
				{11,12,13,14,15},
				};	//int[][] myarr = new int[3][]
		//myarr와 myarr2의 배열의 배열에 저장된 값을 출력하기
		for(int j=0;j<myarr.length;j++) {
			for(int i=0;i<myarr[j].length;i++) {
				System.out.print(myarr[j][i]+"\t");
				}
			System.out.println( );
			}
		for(int j=0;j<myarr2.length;j++) {
			for(int i=0;i<myarr2[j].length;i++) {
				System.out.print(myarr2[j][i]+"\t");
				}
			System.out.println( );
			}
	}

}


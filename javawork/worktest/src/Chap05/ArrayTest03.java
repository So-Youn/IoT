package Chap05;
//배열 액세스하기
public class ArrayTest03 {

	public static void main(String[] args) {
		int[] myarr = new int[5]; // 선언과 생성 동시에
		System.out.println(myarr[0]);
		System.out.println(myarr[1]);
		System.out.println(myarr[2]);
		System.out.println(myarr[3]);
		System.out.println(myarr[4]);
		//베열의 요소의 크기를 출력
		//length 는 배열의 사이즈를 저장하고 있는 기본 변수(자동으로 제공)
		System.out.println("배열의 요소의 갯수 :" +myarr.length);
		System.out.println("==================");
		for(int i=0;i<myarr.length;i++) {
			System.out.println(myarr[i]);
		}
	}

}
/*//
 Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 5
 => 없는 요소 불러들였을 경우, 범위 잘못 선정*/
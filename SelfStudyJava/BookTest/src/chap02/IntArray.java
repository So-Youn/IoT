package chap02;
//구성 자료형이 int형 인 배열 (요솟수는  5:배열 초기자에 의해  생성）
public class IntArray {
	public static void main(String[] args) {
		int[] a = new int[5]; // 배열의 선언
		//5개의 저장공간 차지
		//배열의 구성요소는 자동으로 0으로 초기화 된다.
		a[1] = 37;
		a[2] = 51;
		a[4] = a[1]*2;
		
		for(int i=0;i<a.length;i++)
			System.out.println("a["+i+"]="+a[i]);
	}

}

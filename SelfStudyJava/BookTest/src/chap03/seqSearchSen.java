package chap03;
//선형 검색(보초법)
import java.util.*;
public class seqSearchSen {
	// 요솟수가 n인 배열 a에서 key와 같은 요소를 보초법으로 선형 검색합니다.
	static int seqSearchSen(int[] a, int n, int key) {
		int i = 0;

		a[n] = key;					// 보초를 추가

		while (true) {
			if (a[i] == key)		// 검색 성공!
				break;
			i++;
		}
		return i == n ? -1 : i;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("요솟수：");
		int num = sc.nextInt();
		int[] x = new int[num+1]; // 요솟수 num + 1
		
		for(int i=0;i<num;i++) {
			System.out.print("x[" + i + "]：");
			x[i] = sc.nextInt();
		}
		
		System.out.println("검색 값 : ");
		
		int key = sc.nextInt();
		
		int index = seqSearchSen(x,num,key);
		
		if(index == -1)
			System.out.println("그 값의 요소가 없습니다.");
		else
			System.out.println(key+"은(는) x[" + index + "]에 있습니다.");
	}
}

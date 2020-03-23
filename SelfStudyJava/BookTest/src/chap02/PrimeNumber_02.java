package chap02;
//1,000 이하의 소수를 열거
public class PrimeNumber_02 {
	public static void main(String[] args) {
		int count =0;
		int ptr =0;						//찾을 소수의 갯수
		int[] prime = new int[500];    // 소수 저장
		
		prime[ptr++] = 2;   // 2는 소수.
		
		for (int n = 3; n <= 1000; n+=2) {  //대상은 홀수만
			int i;
			for(i=1;i<ptr;i++) {
				count++;
				if(n % prime[i] ==0)
					break;
			}
			if(ptr ==i)
				prime[ptr++] = n;
		}
		for(int i=0;i<ptr;i++)    //찾은 ptr개의 소수를  나타냄
			System.out.println(prime[i]);
		System.out.println("나눗셈을 수행한 횟수:" +count);
	}

}

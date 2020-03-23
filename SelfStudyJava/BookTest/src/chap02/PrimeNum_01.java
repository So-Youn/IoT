package chap02;
//1,000 ÀÌÇÏÀÇ ¼Ò¼ö¸¦ ¿­°Å
public class PrimeNum_01 {
	public static void main(String[] args) {
		int counter =0; // ³ª´°¼ÀÀÇ È½¼ö
		for (int n = 2; n <= 1000; n++) {
			int i;
			for(i =2;i<n;i++) {
				counter++; // ¿¬»ê È½¼ö °è»ê
				if(n%i==0)
					break;
			}
			if(n==i)
				System.out.println(n);
		}
		System.out.println("³ª´°¼ÀÀ» ¼öÇàÇÑ È½¼ö:"+counter);
	}

}

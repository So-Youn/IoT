package chap09.API.lang;
//String과 StringBuffer의 성능비교
//Stiring은 + 때마다 객체를 새로 생성하는 반면에 
//StringBuffer는 생성된 값을 계속 집어넣는 방식.
public class StringStringBufferTest {
	//String의 작업을 체크하는 메소드
	public static void stringCheck(int count) {
		//시작할때 시간 측정 - nano초
		long start = System.nanoTime();//10억분의 1초
		String str = new String("자바");
		for(int i = 1;i<=count;i++) {
			str = str+"java";
		}
		long end = System.nanoTime();
		long time = end-start;
		System.out.println("str=str+java");
		System.out.println("걸린시간 :"+time);	
	}
	//StringBuffer의 작업을 체크하는 메소드
	public static void stringBufferCheck(int count) {
		//시작할때 시간 측정 - nano초
		long start = System.nanoTime();//10억분의 1초
		StringBuffer sb= new StringBuffer("자바");
		for(int i=0;i<=count;i++) {
			sb.append("java");
		}
		long end = System.nanoTime();
		long time = end-start;
		System.out.println("sb.append(\"java\")");
		System.out.println("걸린시간 :"+time);	
	}
	public static void main(String[] args) {
		int count = 10000;
		System.out.println("실행횟수 :"+count);
		stringCheck(count);
		stringBufferCheck(count);
	}

}

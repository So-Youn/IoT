package chap09.API.lang;
//String클래스의 기본 메소드와 String클래스의 특징
//=> 문자열 처리 메소드를 자주 호출하거나 +연산자로 문자열을 연결하는 작업이 많은 경우 (문자열 조작이 빈번하게 일어나는 경우)
//   String을 사용하지 않고 StringBuffer or StringBuilder를 이용한다.
public class StringTest03 {
	public static void main(String[] args) {
		String str1 = new String("java programming");
		String str2 = new String("재밌다.");
		//변환
		System.out.println("str1.toUpperCase()=>"+str1.toUpperCase());
		//대문자로 변환
		System.out.println("원본 데이터:"+str1);
		System.out.println("str1.toLowerCase()=>"+str1.toLowerCase());
		//소문자로 변환
		System.out.println("str1.substring(2)=>"+str1.substring(2));
		//v부터 전체 다 출력
		System.out.println("str1.substring(2,8)=>"+str1.substring(2,8));
		//2~7번 위치까지 출력(a<=str1<b)
		System.out.println("str1.replance('a','A')=>"+str1.replace('a', 'A'));
		//'a'를 찾아서 'A'로 바꾸기
		System.out.println("원본 데이터:"+str1);
		
	}

}

package chap09.API.lang;
//StringBuffer 테스트
public class StringBufferTest {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("java programming");
		System.out.println("원본=>"+sb);
		
		sb.append("재밌다");	// 맨 끝에 문자열 + 기능 ( 원본 변경)
		System.out.println("원본=>"+sb);
		
		sb.insert(2,"자바");	//index위치에 문자열을 추가
		System.out.println("원본=>"+sb);
		
		sb.delete(2,6);	//begin ~ end-1 삭제
		System.out.println("원본=>"+sb);
		
		sb.reverse();	//문자열의 순서를 거꾸로
		System.out.println("원본=>"+sb);
		
		
	}

}

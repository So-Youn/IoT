package test;

public class PagingTest {
	public static void main(String[] args) {
		int totalCount = 25; // 실제 DB 에 저장된 게시물의 수
		int countList = 10; //한 페이지에 출력되는 페이지 수 
		int totalPage = totalCount/countList;
		int page = 2; //현재  페이지 번호 
		int countPage=10; // 한 화면에 출력될 페이지 수 
		if(totalCount % countList > 0) {
			totalPage++;
		}
		//나머지가 있을 경우에만 +1 을 해준다.
		System.out.println("총페이지"+totalPage);
		//현재 페이지 번호가 총페이지 번호보다 크다면 ? 치환해주기
		if(totalPage<page) {
			page = totalPage;
		}
		System.out.println("현재 페이지"+page);
	}
		
}
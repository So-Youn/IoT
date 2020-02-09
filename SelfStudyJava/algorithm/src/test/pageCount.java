package test;

public class pageCount {
	public static void main(String[] args) {
		int page = 22;
		int countPage = 10;
		int countList = 10;
		int totalCount = 255;
		int totalPage = totalCount/countList;
		if(totalCount % countList >0) {
			totalPage++;
		}
		if ( totalPage<page) {
			page = totalPage;
		}
		
		int startPage = ((page-1)/10)*10+1;
		int endPage = startPage + countPage -1;
		
		//마지막 페이지 보정
		if(endPage >totalPage) {
			endPage = totalPage;
		}
		if(startPage > 1) {
			System.out.println("<a href=\"?page="+(page-1)+"\">이전</a>");
		}
		//[paging]
		for (int i = startPage; i < endPage; i++) {
			// 21  22  23  24  25 
			if(i == page) { //현재 페이지는 굵게 표시
				System.out.print(" <b>" + i + "</b>");
			}else {
				System.out.print(" "+i+" ");
			}
		}
		if(page < totalPage) {
			System.out.println("<a href=\"?page="+(page+1)+"\">다음</a>");
		}
		if(endPage <totalPage) {
			System.out.println("<a href=\"?page="+totalPage+"\">끝</a>");
		}
	}
}

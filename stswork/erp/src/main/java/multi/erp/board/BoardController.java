package multi.erp.board;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
	/*
	 * @RequestMapping("/menu/board.do") public String showlist() { return
	 * "menu/board"; }
	 */

	@Autowired
	BoardService service;

	@RequestMapping("/board/list.do")
	public ModelAndView boardList(String category) {
		System.out.println("category=>" + category);
		ModelAndView mav = new ModelAndView();
		// 1.요청정보 추출
		// 2.비즈니스 메소드 호출
		List<BoardVO> list = service.boardList(category);
		System.out.println(list);
		// 3.데이터 공유 - jsp 페이지에서 응답뷰 만들 때 사용
		// => 기본값 : request에 저장
		mav.addObject("boardlist", list);
		mav.addObject("category", category);
		// 4.뷰의 이름 등록
		mav.setViewName("board/list"); // tiles에 등록하는 이름과 일치

		// 5. 기본이 forward
		return mav;
	}

	// 게시물을 작성하기 위한 뷰를 response할 메소드
	@RequestMapping(value = "/board/write.do", method = RequestMethod.GET) // get방식일 때는 이 메소드
	public String insertView() {
		return "board/write"; // tiles에 등록한 뷰 이름

	}

	// 입력한 글을 실제 db에 저장하는 메소드
	@RequestMapping(value = "/board/write.do", method = RequestMethod.POST) // post 방식일 때는 이 메소드
	public String insert(BoardVO board) {
		System.out.println("*****************" + board);
		int result = service.insert(board);
		System.out.println("##################" + result);
		return "redirect:/board/list.do?category=all";

	}

	@RequestMapping(value = "/board/search.do")
	public ModelAndView search(String tag, String search) {
		ModelAndView mav = new ModelAndView();
		List<BoardVO> list = service.searchList(tag, search);
		mav.addObject("boardlist", list);
		mav.setViewName("board/list");
		return mav;

	}

	/* ajax로 카테고리별 게시판 데이터를 요청하는 메소드 
	 * => 컨트롤러 메소드처럼ModelAndView를 리턴하지 않고 일반 메소드 처럼 
	 * 조회한 데이터를 ArrayList로 리턴하면 jackjon라이브러리가 자동으로 
	 * ArrayList<BoardVO>를 json으로 변환해서 리턴해준다. */
	@RequestMapping(value="/board/ajax_boardlist.do",
					method=RequestMethod.GET,
					produces="application/json;charset=utf-8")	//ajax로 통신하면서 클라이언트에게 명시해줄 데이터를 produces에 붙인다.
	public @ResponseBody ArrayList<BoardVO> categoryList(String category) {
		ArrayList<BoardVO> boardlist = (ArrayList<BoardVO>)service.boardList(category);
		System.out.println("ajax 통신"+boardlist.size());
		return boardlist;
	}
}

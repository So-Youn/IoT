package member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class SearchController{
	@RequestMapping("/search.do")
	public ModelAndView search(String search){ //파라미터명 search와 똑같이 맞춰주기
		
		System.out.println("검색어 =>"+search);
		return new ModelAndView("test/index");
	}

}

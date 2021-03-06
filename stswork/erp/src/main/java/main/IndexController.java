package main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@RequestMapping("/index.do")
	public String index() {
		return "index"; 	
		/*		/idex.do 로 요청하면 `index`라는 이름의 뷰를 forward하겠다는 의미
		 * 		=> index라는 뷰를 만드는 기준은 내 스프링 설정 파일에 등록된 ViewResolver에 따라 다르게 작성된다.*/
	}
}

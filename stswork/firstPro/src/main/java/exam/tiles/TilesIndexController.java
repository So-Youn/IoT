package exam.tiles;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//메뉴 화면을 선택했을 때 화면을 교체해서 보여주도록 처리하는 컨트롤러
//컨트롤러에 처리할 메소드를 여러 개 등록해서 사용할 수 있다. - 비슷한 기능을 처리하는 경우
@Controller
public class TilesIndexController {
	@RequestMapping("/exam/index.do")	///exam/index.do로 요청하면 실행해주세요 라는 표시
	public String index() {
		return "index"; //tiles 설정 파일에 등록된 view의 이름
	}
	@RequestMapping("/menu/mybatis.do")
	public String mybatisView() {   //tiles에 등록된 menu/mybatis를 기준으로 view를 만들어라
		return "menu/mybatis";
	}
	@RequestMapping("/menu/advanced.do")
	public String advancedView() {
		return "menu/advanced";
	}
}

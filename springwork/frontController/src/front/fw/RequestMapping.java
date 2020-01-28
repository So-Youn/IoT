package front.fw;

import java.util.HashMap;

import member.LoginAction;
import member.MemberInsert;
import product.ProductList;

/*
 * FrontServlet이 넘겨준 요청path를 가지고 실제 실행할 클래스의 객체를 만들어서 리턴하는 작업을 수행
 * => 미리 요청 path별로 실행할 실제 클래스를 등록한 설정파일을 보고 객체를 찾아서 생성
 *    mycommand.properies파일에 등록된 요청path를 보고 실행할 객체를 찾는다.
 *    XML파일이나 properties파일을 파싱하는 코드를 정의
 */
public class RequestMapping {
	//xml이나 properties파일을 파싱해서 생성해놓은 객체를 저장할 map
	//요청 path가 key, 실제 실행할 객체 value
	private HashMap<String,Action> actionMap = new HashMap<String,Action>();
	public RequestMapping() {
		//생성자 내부에서 설정파일을 파싱해서 객체로 만드는 코드가 정의되어야 한다.
	}

	public Action mapping(String path) {
		//매개변수로 전달된 path로 등록된 Action 객체를 actionMap에서 찾아서 리턴하는 코드가 정의되어야 하나
		//우리는 if...else if로 우선 처리
		//현재 코드는 연습용이므로 추가가 되면 mapping메소드를 변경해야 하지만 
		//실제는 xml 문서나 properties파일을 분석해서 자동으로 만들도록 코드를 정의해야 할 것이므로
		//코드를 변경하지 않아도 된다.
		Action action = null;
		if(path.equals("/product/list.do")) {
			action = new ProductList();
		}else if(path.equals("/member/customer/insert.do")){
			action = new MemberInsert();
		}else if(path.equals("/login.do")) {
			action = new LoginAction();
		}
		//.........
		return action;
	}
}

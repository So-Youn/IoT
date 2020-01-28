package di.setterexam;
public class InsaImpl implements Insa {
	//멤버변수를 직접 만들지 않고 전달받을 때.
	MemberDAO dao;
	public InsaImpl() {
		System.out.println("기본 생성자 - InsaImpl");
	}
	
	public InsaImpl(MemberDAO dao) {
		super();
		this.dao = dao;
		System.out.println("InsaImpl 매개변수 1개 생성자"); //여러개 한번에 전달
	}
	
	public void setDao(MemberDAO dao) { //setter메소드를 통해 하나하나 전달 받을 수 있다.
		System.out.println("setDao() 호출");
		this.dao = dao;
	}

	@Override
	public void addUser(MemberDTO user) {
		dao.add(user);		
	}

	@Override
	public MemberDTO getUser(String id) {
		dao.getUser("id");
		return null;
	}

}

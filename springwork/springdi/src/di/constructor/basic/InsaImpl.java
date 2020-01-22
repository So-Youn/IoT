package di.constructor.basic;
public class InsaImpl implements Insa {
	//멤버변수를 직접 만들지 않고 전달받을 때.
	MemberDAO dao;
	
	
	public InsaImpl(MemberDAO dao) {
		super();
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

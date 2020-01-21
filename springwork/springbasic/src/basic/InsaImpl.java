package basic;
public class InsaImpl implements Insa {
	//MemberDAO dao = new MemberDAO();
	MemberDAO dao;
	//1.생성자를 이용해서 작업하는 방식
	public InsaImpl() {	//기본 생성자
		
	}
	public InsaImpl(MemberDAO dao) {
		super();
		this.dao = dao;
	}
	//2.setter메소드를 이용해서 작업하는 방법
	
	@Override
	public void addUser(MemberDTO user) {
		dao.add(user);		
	}

	

	public void setDao(MemberDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public MemberDTO getUser(String id) {
		dao.getUser("id");
		return null;
	}

}

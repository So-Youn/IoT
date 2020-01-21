package basic;
public interface Insa {
	public void addUser(MemberDTO user);
	public MemberDTO getUser(String id);
	void setDao(MemberDAO dao);	//insa가 interface이므로 public 붙이지 않아도 된다.
}


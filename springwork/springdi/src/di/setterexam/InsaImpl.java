package di.setterexam;
public class InsaImpl implements Insa {
	//��������� ���� ������ �ʰ� ���޹��� ��.
	MemberDAO dao;
	public InsaImpl() {
		System.out.println("�⺻ ������ - InsaImpl");
	}
	
	public InsaImpl(MemberDAO dao) {
		super();
		this.dao = dao;
		System.out.println("InsaImpl �Ű����� 1�� ������"); //������ �ѹ��� ����
	}
	
	public void setDao(MemberDAO dao) { //setter�޼ҵ带 ���� �ϳ��ϳ� ���� ���� �� �ִ�.
		System.out.println("setDao() ȣ��");
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

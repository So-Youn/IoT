package jdbc.member.exam;

import java.util.ArrayList;

public interface MemberDAO {
	int insert(MemberDTO user);			//사원 등록
	int update(String id, String addr); //사원정보 수정
	int delete(String id);				//사원 탈퇴
	//void select();						
	ArrayList<MemberDTO> memberList();	//전체 사원목록 조회
	ArrayList<MemberDTO> findByAddr(String addr);	//주소로 검색하기
	MemberDTO Login(String id, String pass);
	//로그인은 단순히 있냐 없냐가 아닌 사후처리가 필요하기 때문에 memberDTO를 데이터타입으로 
}
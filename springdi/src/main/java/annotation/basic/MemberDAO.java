package annotation.basic;

import org.springframework.stereotype.Component;

@Component("memberdao")
public class MemberDAO implements DAO{
	public MemberDAO() {
		System.out.println("MemberDAO 생성자");
	}
	
	@Override
	public void add(MemberDTO user){
		System.out.println("MemberDAO 회원가입");
	}
	@Override
	public MemberDTO getUser(String id){
		System.out.println("MemberDAO 회원정보 상세조회");
		return null;
	}
}

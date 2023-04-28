package annotation.basic;

import org.springframework.stereotype.Repository;

@Repository("empdao")
public class EmpDAO implements DAO{
	public EmpDAO() {
		System.out.println(" EmpDAO 생성자");
	}
	
	@Override
	public void add(MemberDTO user){
		System.out.println(" EmpDAO 회원가입");
	}
	@Override
	public MemberDTO getUser(String id){
		System.out.println(" EmpDAO 회원정보 상세조회");
		return null;
	}
}

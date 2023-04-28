package basic;
public class MemberDAO implements DAO{
	public MemberDAO() {
		System.out.println("MemberDAO 생성자");
	}
	
	@Override
	public void add(MemberDTO user){
		System.out.println("MemberDAO add");
	}
	@Override
	public MemberDTO getUser(String id){
		System.out.println("MemberDAO getUser");
		return null;
	}
}

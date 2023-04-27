package basic;
public class InsaImpl implements Insa {
	MemberDAO dao = new MemberDAO();
//	public InsaImpl (MemberDAO dao) {
//		this.dao = dao;
//	}
	public void setDao(MemberDAO dao) {
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

package basic;
public class TestMain {
	public static void main(String[] args) {
		MemberDAO dao = new MemberDAO();
		Insa insa = new InsaImpl();
		insa.setDao(dao);
		MemberDTO user = new MemberDTO("jang","1234","�嵿��");

		insa.addUser(user);

	}

}
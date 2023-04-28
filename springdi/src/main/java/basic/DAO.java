package basic;

public interface DAO {
	void add(MemberDTO user);
	MemberDTO getUser(String id);
}
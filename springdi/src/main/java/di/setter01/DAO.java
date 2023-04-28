package di.setter01;

public interface DAO {
	void add(MemberDTO user);
	MemberDTO getUser(String id);
}
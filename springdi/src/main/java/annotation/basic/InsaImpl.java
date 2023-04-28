package annotation.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("insa")
public class InsaImpl implements Insa {
	//
	@Autowired
	@Qualifier("empdao")
	DAO dao;

	public InsaImpl() {
		System.out.println("InsaImpl 기본 생성자");
	}

	public InsaImpl(DAO dao) {
		super();
		System.out.println("InsaImpl DAO 생성자");
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

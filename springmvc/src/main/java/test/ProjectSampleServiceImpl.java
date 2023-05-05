package test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// 서비스에서 DAO 메소드 호출
@Service
public class ProjectSampleServiceImpl implements ProjectSampleService {
	@Autowired
	ProjectSampleDAO dao;

	public ProjectSampleServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void servicetest(EmpDTO user) {
		// TODO Auto-generated method stub
		System.out.println("나 service");
		dao.insert(user);
	}

	@Override
	public List<EmpDTO> selectList() {
		// TODO Auto-generated method stub

		return dao.select();
	}

	@Override
	public EmpDTO selectDetail(String id) {
		// TODO Auto-generated method stub
		EmpDTO user = dao.read(id);
		return user;
	}

	@Override
	public int update(EmpDTO user) {
		// TODO Auto-generated method stub
		int result = dao.update(user);
		return result;
	}

}

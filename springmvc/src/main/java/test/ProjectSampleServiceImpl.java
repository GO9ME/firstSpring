package test;

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


}

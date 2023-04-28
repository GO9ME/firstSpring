package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// 서비스에서 DAO 메소드 호출
@Service
public class ProjectSampleServiceImpl implements ProjectSampleService {
	@Autowired
	ProjectSampleDAO dao;
	
	@Override
	public void servicetest() {
		// TODO Auto-generated method stub
		System.out.println("나 service");
		dao.test();
	}
}

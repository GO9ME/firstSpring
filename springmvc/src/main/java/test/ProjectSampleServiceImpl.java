package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//서비스에서 DAO 메소드 호출
@Service("service")
public class ProjectSampleServiceImpl implements ProjectSampleService {
	@Autowired
	ProjectSampleDAO dao;
	
	@Override
	public void serviceTest() {
		System.out.println("나는 서비스");
		dao.test();
	}
	
}

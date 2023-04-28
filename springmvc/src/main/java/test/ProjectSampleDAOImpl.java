package test;

import org.springframework.stereotype.Repository;

@Repository
public class ProjectSampleDAOImpl implements ProjectSampleDAO{
		
	
	@Override
	public void test() {
		// TODO Auto-generated method stub
		System.out.println("나 dao");
	}
}

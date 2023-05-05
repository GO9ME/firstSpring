package test;

import java.util.List;

public interface ProjectSampleService {
	void servicetest(EmpDTO user);

	List<EmpDTO> selectList();

	EmpDTO selectDetail(String id);
	
	int update(EmpDTO user);

}

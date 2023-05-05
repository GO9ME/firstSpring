package test;

import java.util.List;

public interface ProjectSampleDAO {
	void test();

	int insert(EmpDTO user);

	List<EmpDTO> select();
	
	EmpDTO read(String id);
	
	int update(EmpDTO dto);
	
	int delete(String id);
}

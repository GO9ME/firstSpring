package kr.multicampus.erp.dept;

import java.util.List;

public interface DeptDAO {
	List<DeptDTO> getDeptName();
	int insert(DeptDTO dept);
	int insertFile(List<DeptFileDTO> deptFiledtoList);
	//전체사원목을 조회하는 메소드
	public List<DeptDTO> select();
	public int delete(String deptno);
	public DeptDTO read(String deptno);
	int update(DeptDTO dept);
}

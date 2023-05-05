package kr.multicampus.erp.dept;

import java.util.List;

import org.springframework.stereotype.Service;

public interface DeptService {
	int insert(DeptDTO dept);
	List<DeptDTO> getDeptName();
	//전체사원목을 조회하는 메소드
	public List<DeptDTO> select();
	public int delete(String deptno);
	public DeptDTO read(String deptno);
	int update(DeptDTO dept);
	int insert(DeptDTO dept, List<DeptFileDTO> deptFiledtolist);
}

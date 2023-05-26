package kr.multi.erp.dept;

import java.util.List;


public interface DeptDAO {
	int insert(DeptDTO dept);
	List<DeptDTO> getDeptName();
	// 부서의 이미지 파일을 저장하는 메소드
	// 전체사원목을 조회하는 메소드
	public List<DeptDTO> select();
	public int delete(String deptno);
	public DeptDTO read(String deptno);
	int update(DeptDTO dept);
	
	//하위 부서를 조회하기 위한 메소드  
	public List<DeptDTO> getSubDeptlist(String uppercode);
}

package kr.multi.erp.member;

import java.util.List;

public interface EmpDAO {
	// 사원등록을 위한 메소드
	public int insert(EmpDTO user);
	// 전체 사원목록을 조회하는 메소드
	public List<EmpDTO> select();
	public int delete(String id);
	public EmpDTO read(String id);
	public EmpDTO login(String id, String pass);
	int update(EmpDTO user);
}

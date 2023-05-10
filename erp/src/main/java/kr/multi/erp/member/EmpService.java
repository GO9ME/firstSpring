package kr.multi.erp.member;

import java.util.List;
// DAO의 메소드를 호출
// 컨트롤러에서 받은 데이터를 가공하고 DAO한테 받은 데이터를 가공하는 작업 - 비지니스 로직
// 트랜잭션을 처리하기 위해서 논리적인 작업명 기술..
public interface EmpService {
	// 사원등록을 위한 메소드
	public int insert(EmpDTO user);
	// 전체 사원목록을 조회하는 메소드
	public List<EmpDTO> select();
	public int delete(String id);
	public EmpDTO read(String id);
	public EmpDTO login(String id, String pass);
	int update(EmpDTO user);
}

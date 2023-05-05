package kr.multi.erp.dept;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeptServiceImpl implements DeptService {
	@Autowired
	DeptDAO dao;
		
	@Override
	public int insert(DeptDTO dept) {
		// TODO Auto-generated method stub
		int result = dao.insert(dept);
		System.out.println(result);
		return 0;
	}

	@Override
	public List<DeptDTO> getDeptName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DeptDTO> select() {
		// TODO Auto-generated method stub
		return dao.select();
	}

	@Override
	public int delete(String deptno) {
		// TODO Auto-generated method stub
		int result = dao.delete(deptno);
		return result;
	}

	@Override
	public DeptDTO read(String deptno) {
		// TODO Auto-generated method stub
		DeptDTO dept =  dao.read(deptno);
		return dept;
	}

	@Override
	public int update(DeptDTO dept) {
		// TODO Auto-generated method stub
		return 0;
	}

}

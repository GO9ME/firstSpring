package kr.multi.erp.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class EmpServiceImpl implements EmpService {
	@Autowired
	EmpDAO dao;

	@Override
	public int insert(EmpDTO user) {
		return dao.insert(user);
	}

	@Override
	public List<EmpDTO> select() {
		return dao.select();
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public EmpDTO read(String id) {
		// TODO Auto-generated method stub
		return dao.read(id);
	}

	@Override
	public EmpDTO login(String id, String pass) {
		return dao.login(id,pass);
	}

	@Override
	public int update(EmpDTO user) {
		return dao.update(user);
	}

}

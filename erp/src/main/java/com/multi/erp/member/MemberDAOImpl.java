package com.multi.erp.member;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.multi.erp.dept.DeptDTO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	SqlSession sqlSession;

	public MemberDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public MemberDAOImpl(SqlSession sqlSession) {
		super();
		this.sqlSession = sqlSession;
	}

	@Override
	public List<MemberDTO> getTreeEmpList(String deptno) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("com.multi.erp.member.treedata",deptno);
	}

	@Override
	public int insert(MemberDTO user) {
		// TODO Auto-generated method stub
		return sqlSession.insert("com.multi.erp.member.insert", user);
	}

	@Override
	public List<MemberDTO> getMemberList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MemberDTO read(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberDTO> search(String column, String search, String pass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(MemberDTO user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MemberDTO login(MemberDTO loginUser) {
		// TODO Auto-generated method stub\
		return sqlSession.selectOne("com.multi.erp.member.login", loginUser);
	}

	@Override
	public boolean idCheck(String id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("com.multi.erp.member.idcheck", id);
	}

	@Override
	public MemberDTO findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<JobDTO> selectJob(){
		return sqlSession.selectList("com.multi.erp.member.selectJob");
	}
	@Override
	public List<DeptDTO> selectDeptname(String job_category){
		return sqlSession.selectList("com.multi.erp.member.selectDeptname", job_category);
	}
}

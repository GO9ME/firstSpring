package com.multi.erp.member;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kr.multi.erp.dept.DeptDTO;

public interface MemberService {
	List<MemberDTO> getTreeEmpList(String deptno);
	int insert(MemberDTO usr);
	int insert(MemberDTO user,MultipartFile file,String realpath,String filename);
	public boolean idCheck(String id);
	List<MemberDTO> getMemberList();
	int delete(String id);
	MemberDTO read(String id);
	List<MemberDTO> search(String column, String search
					,String pass);
	int update(MemberDTO user);
	MemberDTO login(MemberDTO loginUser);
	List<JobDTO> selectJob();
	List<DeptDTO> selectDeptname(String job_category);

}

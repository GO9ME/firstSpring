package com.multi.erp.member;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.multi.erp.board.FileUploadLogic;

import kr.multi.erp.dept.DeptDTO;

@Service
public class MemberServiceImpl implements MemberService {
	MemberDAO dao;
	FileUploadLogic fileuploadservice;

	public MemberServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public MemberServiceImpl(MemberDAO dao, FileUploadLogic fileuploadservice) {
		super();
		this.dao = dao;
		this.fileuploadservice = fileuploadservice;
	}

	@Override
	public int insert(MemberDTO usr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<MemberDTO> getTreeEmpList(String deptno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(MemberDTO user, MultipartFile file, String realpath, String filename) {
		// TODO Auto-generated method stub
		int result = 0;
		try {
			result = dao.insert(fileuploadservice.uploadFile(file, realpath, user));
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean idCheck(String id) {
		// TODO Auto-generated method stub
		return dao.idCheck(id);
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
		// TODO Auto-generated method stub
		MemberDTO user = dao.login(loginUser);

		if (user != null) {
			String menupath = user.getMenupath();
			menupath = menupath.substring(menupath.indexOf("/") + 1, menupath.indexOf("_"));
			user.setMenupath(menupath);
			System.out.println("menu path : " + menupath);
		}
		return user;
	}
	
	@Override 
	public List<JobDTO> selectJob(){
		return dao.selectJob();
	}
	
	@Override
	public List<DeptDTO> selectDeptname(String job_category){
		return dao.selectDeptname(job_category);
	}

}

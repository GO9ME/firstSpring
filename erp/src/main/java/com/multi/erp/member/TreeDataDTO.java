package com.multi.erp.member;

import java.util.List;

import kr.multi.erp.dept.DeptDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreeDataDTO {
	private List<MemberDTO> memberlist;
	private List<DeptDTO> deptlist;
	
}

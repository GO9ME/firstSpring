package com.multi.erp.member;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreeDTO {
	String deptname;
	String name;
	List<TreeDTO> children;
}

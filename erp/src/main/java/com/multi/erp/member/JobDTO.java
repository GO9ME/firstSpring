package com.multi.erp.member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobDTO {
	String job_id;
	String job_name;
	String job_category;
	String menupath;

}

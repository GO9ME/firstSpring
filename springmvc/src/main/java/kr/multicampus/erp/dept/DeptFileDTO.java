package kr.multicampus.erp.dept;

public class DeptFileDTO {
	
	private String deptno;
	private String originalFilename;
	private String storeFilename;
	private String deptImageFileno;
	
	
	public DeptFileDTO() {
		// TODO Auto-generated constructor stub
	}
	public DeptFileDTO(String deptno, String originalFilename, String storeFilename, String deptImageFileno) {
		super();
		this.deptno = deptno;
		this.originalFilename = originalFilename;
		this.storeFilename = storeFilename;
		this.deptImageFileno = deptImageFileno;
	}
	
	
	public DeptFileDTO(String originalFilename, String storeFilename) {
		super();
		this.originalFilename = originalFilename;
		this.storeFilename = storeFilename;
	}
	
	@Override
	public String toString() {
		return "DeptFileDTO [deptno=" + deptno + ", originalFilename=" + originalFilename + ", storeFilename="
				+ storeFilename + ", deptImageFileno=" + deptImageFileno + "]";
	}
	public String getDeptno() {
		return deptno;
	}
	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}
	public String getOriginalFilename() {
		return originalFilename;
	}
	public void setOriginalFilename(String originalFilename) {
		this.originalFilename = originalFilename;
	}
	public String getStoreFilename() {
		return storeFilename;
	}
	public void setStoreFilename(String storeFilename) {
		this.storeFilename = storeFilename;
	}
	public String getDeptImageFileno() {
		return deptImageFileno;
	}
	public void setDeptImageFileno(String deptImageFileno) {
		this.deptImageFileno = deptImageFileno;
	}
	
	
	
	
}
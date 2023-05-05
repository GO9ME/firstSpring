package kr.multicampus.erp.dept;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;
import org.springframework.stereotype.Repository;

@Repository
public class DeptDAOImpl implements DeptDAO {
	@Autowired
	JdbcTemplate template;
	
	@Override
	public List<DeptDTO> getDeptName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(DeptDTO dept) {
		String sql = "insert into dept values(?,?,?null,?,?,?,?,?,?,?)";
		return template.update(sql, dept.getDeptno(),dept.getDeptname(),dept.getDeptStartDay(),dept.getDeptlevel(),dept.getDeptstep()
				,dept.getDeptuppercode(),dept.getJob_category(),dept.getMgr_id(),dept.getDeptaddr(),dept.getDepttel());
	}
	@Override
	public int insertFile(List<DeptFileDTO> deptFiledtoList) {
		String sql = "insert into deptImage_file values(last_insert_id(), ?, ?, ? )";
		template.batchUpdate(sql, deptFiledtoList, deptFiledtoList.size(), 
				new ParameterizedPreparedStatementSetter<DeptFileDTO>() {
					@Override
					public void setValues(PreparedStatement ps, DeptFileDTO deptfiledto) throws SQLException {
						// TODO Auto-generated method stub
						ps.setString(1, deptfiledto.getOriginalFilename());
						ps.setString(2, deptfiledto.getStoreFilename());
						ps.setString(3, deptfiledto.getDeptImageFileno());
					}
				});
		return 0;
	}

	@Override
	public List<DeptDTO> select() {
		//jdb작업할 떄 작성했던 모든 코드가 query 메소드 내부에서 자동으로 처리
		//매번 달라지는 sql문과 조회한 레코드를 어떤 dto에 매핑할 것인지 정보를 담고 있는 RowMapper 객체만 넘겨주면
		//자동으로 모든레코드를 List 로 만들어서 리턴
		return template.query("select * from dept", new DeptRowMapper());
		
	}
	@Override
	public int delete(String deptno) {
		return template.update("delete from dept where deptno = ?",deptno);
	}

	@Override
	public DeptDTO read(String deptno) {
		// TODO Auto-generated method stub
		return template.queryForObject("select * from dept where deptno = ?", new Object[] {deptno}, new DeptRowMapper());
	}

	@Override
	public int update(DeptDTO dept) {
		String sql = "update dept set mgr_id=?, deptaddr=?, depttel=? where deptno= ?";
		return template.update(sql, dept.getMgr_id(), dept.getDeptaddr(), dept.getDepttel(), dept.getDeptno());
	}

}

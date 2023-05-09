package kr.multi.erp.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmpDAOImpl implements EmpDAO {
	@Autowired
	private JdbcTemplate template;

	@Override
	public int insert(EmpDTO user) {
		String sql = "INSERT INTO myemp VALUES(?,?,?,?,?,1000,?);";
		//JdbcTemplate의 update 메소드를 호출해서 db에 insert
		//sql문과 ?에 대한 값을 매개변수로 전달
		return template.update(sql, user.getDeptno(), user.getName(), user.getId(),user.getPass(),user.getAddr(),user.getGrade());
	}    

	@Override
	public List<EmpDTO> select() {
		// TODO Auto-generated method stub
		return template.query("select * from myemp;", new EmpRowMapper());
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public EmpDTO read(String id) {
		return template.queryForObject("select * from myemp where id = ?;", new Object[] { id }, new EmpRowMapper());
	}

	@Override
	public EmpDTO login(String id, String pass) {
		EmpDTO user = null;
		try {
			 user = template.queryForObject("SELECT * FROM myemp where id = ? and pass = ?", new Object[] { id,pass }, new EmpRowMapper());
		} catch(EmptyResultDataAccessException e) {
			
		}
		return user;
	}

	@Override
	public int update(EmpDTO user) {
		String sql = "UPDATE myemp SET addr=?, grade=? WHERE id=?;";
		return template.update(sql, user.getAddr(), user.getGrade(), user.getId());
	}

}

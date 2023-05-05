package test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProjectSampleDAOImpl implements ProjectSampleDAO{
	
	private JdbcTemplate mytemplate;
	
	@Autowired
	public ProjectSampleDAOImpl(JdbcTemplate mytemplate)  {
		// TODO Auto-generated constructor stub
		super();
		this.mytemplate = mytemplate;
	}
	
	@Override
	public void test() {
		// TODO Auto-generated method stub
		System.out.println("나 dao");
	}
	@Override
	public int insert(EmpDTO user) {
		String sql = "insert into myemp values(?,?,?,?,?,1000,?)";
		return mytemplate.update(sql,user.getDeptno(),user.getName(), user.getId(), user.getPass(),user.getAddr(),user.getGrade());
	}
	@Override
	public List<EmpDTO> select() {
		// TODO Auto-generated method stub
		return mytemplate.query("select * from myemp", new EmpRowMapper());
	}
	@Override
	public EmpDTO read(String id) {
		// TODO Auto-generated method stub
		return mytemplate.queryForObject("select * from myemp where id = ?", new Object[]{id}, new EmpRowMapper());
	}
	@Override
	public int update(EmpDTO dto) {
		// TODO Auto-generated method stub
		String sql = "update myemp set addr=?, grade=? where id = ?";
		return mytemplate.update(sql, dto.getAddr(), dto.getGrade(), dto.getId());
	}
	
	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		String sql = "delete from myemp where id =?";
		return mytemplate.update(sql, id);
	}
}

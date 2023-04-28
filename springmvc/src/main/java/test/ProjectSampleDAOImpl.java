package test;

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
}

package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.multi.erp.member.EmpDTO;

@Repository
public class ProjectSampleDAOImpl implements ProjectSampleDAO {

	@Autowired
	private JdbcTemplate template;

	@Override
	public void test() {
		// TODO Auto-generated method stub
		System.out.println("나 dao");

		int result = template.queryForObject("select count(id) from myemp", Integer.class);
		System.out.println("레코드 갯수 : " + result);

	}

	@Override
	public int insert(EmpDTO user) {
		String sql = "insert into myemp values(?,?,?,?,?,1000,?)";
		return template.update(sql, user.getDeptno(), user.getName(), user.getId(), user.getPass(), user.getAddr(),
				user.getGrade());
	}
}

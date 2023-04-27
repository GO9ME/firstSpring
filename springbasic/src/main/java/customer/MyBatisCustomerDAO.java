package customer;

import java.util.HashMap;
import java.util.Map;

public class MyBatisCustomerDAO implements CustomerDAO {
	static Map<String, CustomerDTO> map = new HashMap<String, CustomerDTO>();

	@Override
	public void add(CustomerDTO user) {
		// TODO Auto-generated method stub
		System.out.println("mybatis에 저잫아기");
		map.put(user.getId(), user);
	}

	@Override
	public CustomerDTO getUser(String id) {
		// TODO Auto-generated method stub
		System.out.println("mybatis에 조회아기");
		CustomerDTO dto =  map.get(id);
		return dto;
	}

}

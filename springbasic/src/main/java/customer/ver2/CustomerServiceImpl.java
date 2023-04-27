package customer.ver2;

public class CustomerServiceImpl implements CustomerService {
	// 소스안에 객체를 생성하는 코드를 분리 - 외부에서 전달 받도록 구현하기
	// dao라는 상위인터페이스ㅔ 변수에 매핑될 객체를 직접 생성해서 작업하지 않고 외부에서 전달받도록 구현
	// 외부에서 전달받기 위해서 객체가 생성될 때 전달 받거나 전달받을 수 있는 메소드를 정의하고 메소드를 통해서 
	// 전달받아야 한다. 
	CustomerDAO dao; // null
	// 1. 생성자를 통해서 전달받기
	public CustomerServiceImpl(CustomerDAO dao) {
		this.dao = dao;
	}
	// 2. 메소드를 통해서 전달받기 - setter 메소드
	public void setDao(CustomerDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public void register(CustomerDTO user) {
		// TODO Auto-generated method stub
		dao.add(user);
	}


	@Override
	public CustomerDTO read(String id) {
		// TODO Auto-generated method stub

		return dao.getUser(id);
	}

}

package customer;

// DAO의 메소드를 호출하는 클래스

public interface CustomerService {
	void register(CustomerDTO user); // dao의 add 메소드를 호출하는 기능
	CustomerDTO read(String id); // dao클래스의 getUser메소드를 호출하는 기능
}

package customer;

public interface CustomerDAO {
	void add(CustomerDTO user);
	CustomerDTO getUser(String id);
}

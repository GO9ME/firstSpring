package customer.ver2;

public interface CustomerDAO {
	void add(CustomerDTO user);
	CustomerDTO getUser(String id);
}

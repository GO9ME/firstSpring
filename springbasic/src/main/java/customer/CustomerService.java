package customer;

// DAO�� �޼ҵ带 ȣ���ϴ� Ŭ����

public interface CustomerService {
	void register(CustomerDTO user); // dao�� add �޼ҵ带 ȣ���ϴ� ���
	CustomerDTO read(String id); // daoŬ������ getUser�޼ҵ带 ȣ���ϴ� ���
}

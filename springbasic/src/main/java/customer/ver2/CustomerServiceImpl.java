package customer.ver2;

public class CustomerServiceImpl implements CustomerService {
	// �ҽ��ȿ� ��ü�� �����ϴ� �ڵ带 �и� - �ܺο��� ���� �޵��� �����ϱ�
	// dao��� �����������̽��� ������ ���ε� ��ü�� ���� �����ؼ� �۾����� �ʰ� �ܺο��� ���޹޵��� ����
	// �ܺο��� ���޹ޱ� ���ؼ� ��ü�� ������ �� ���� �ްų� ���޹��� �� �ִ� �޼ҵ带 �����ϰ� �޼ҵ带 ���ؼ� 
	// ���޹޾ƾ� �Ѵ�. 
	CustomerDAO dao; // null
	// 1. �����ڸ� ���ؼ� ���޹ޱ�
	public CustomerServiceImpl(CustomerDAO dao) {
		this.dao = dao;
	}
	// 2. �޼ҵ带 ���ؼ� ���޹ޱ� - setter �޼ҵ�
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

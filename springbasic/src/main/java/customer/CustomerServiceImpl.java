package customer;

/*
�����Ͻ� ����
DB ������ ����
Ŭ���̾�Ʈ ������ ����
������ �۾� ����
DAO�� �޼ҵ带 ȣ���ϴ� ����
*/
public class CustomerServiceImpl implements CustomerService {
	// ���ο��� ���Ǵ� ����Ŭ������ ���� �ڵ�� ����
	CustomerDAO dao = new MyBatisCustomerDAO();
//  CustomerDAO dao = new JPACustomerDAO(); 
//	CustomerDAO dao = new SpringJDBCCustomerDAO();
	/*
	 * db���� ��� JPA�� ���� => ���� Ŭ���� �κ��� ���� �ҽ����� �����ؾ� �� OCP ��Ģ�� �������� ���� : ������ �� ����Ǵ� �ҽ���
	 * CustomerServiceImpleŬ���� ���ο��� CustomerDAO���� �����ؾ� �ϴµ� �׷��� �ʰ� CustomerDAO�� ������
	 * Spring JDBBCCustomerDAO�� �����ϰ� ���� ��, ���� �������̽������� �����ϰ� �ְ� �����������̽��� ������ ����Ŭ��������
	 * �����ϰ� ���� �̴� DIP��Ģ�� �������� ���� �̷��� ������ ����Ŭ������ ��� �����ϰ� �Ǹ� �ڵ尡 ����� �� �ۿ� ����
	 */

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

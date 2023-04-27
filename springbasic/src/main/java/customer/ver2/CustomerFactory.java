package customer.ver2;

//Customer�� ���õ� ��ü�� �����ؼ� �������ִ� �ܺΰ�ü - �ܺ�������(��ü�� �����ϴ� �Ĥ���Ʈ�� �����̳ʶ� �θ�)
public class CustomerFactory {
	public CustomerDAO getCustomerDAO() {
		// ������ ���� new�ؼ� ���������� �������̸��� ����� ���������� �о ��ü�� ������ �� �ֵ��� ����
		return new MyBatisCustomerDAO();
	}
	// ���� ��ü�� ���� ����
	public CustomerService getCustomerService() {
		//CustomerDAO dao = getCustomerDAO();
		//CustomerDAO�� CustomerService�� ���� ���� �����ϰ� ������ �ַ� ���������� ���ؼ� ��ü��
		//�ڵ����� ���� �� �ֵ��� �۾�(�ڵ带 ������ ���캸�� ���ؼ� ���� ���� ����)
//		CustomerDAO dao = new MyBatisCustomerDAO();
		
		CustomerService service = new CustomerServiceImpl(getCustomerDAO());
		return service;
	}
}

package customer;

public class Main {

	public static void main(String[] args) {
		// ���񽺴��� �޼ҵ� ȣ�� 
		CustomerService service = new CustomerServiceImpl();
		// ������ ������ ���� ȣ��
		CustomerDTO customer = new CustomerDTO("jang","1234","�嵿��","VVIP");
		service.register(customer);
		System.out.println(customer.getName() + "������ ����");
		
		CustomerDTO customer2 = new CustomerDTO("bts","1234","��ź","VVIP");
		service.register(customer2);
		System.out.println(customer2.getName() + "������ ����");
		
		// ������ ��ȸ�� ���� ȣ��
		CustomerDTO finduser = service.read("bts");
		System.out.println("��ȸ�� User : " + finduser);
	}

}

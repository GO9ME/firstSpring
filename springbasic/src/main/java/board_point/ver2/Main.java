package board_point.ver2;

import customer.ver2.CustomerDTO;
import customer.ver2.CustomerService;
import customer.ver2.CustomerServiceImpl;
import customer.ver2.CustomerFactory;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CustomerFactory factory = new CustomerFactory();
		// ���񽺴��� �޼ҵ� ȣ�� 
		CustomerService service = factory.getCustomerService();
		// ������ ������ ���� ȣ��
		CustomerDTO customer = new CustomerDTO("jang", "1234", "�嵿��", "GOLD");
		service.register(customer);
		System.out.println(customer.getName() + "������ ����");

		CustomerDTO customer2 = new CustomerDTO("bts", "1234", "��ź", "VVIP");
		service.register(customer2);
		System.out.println(customer2.getName() + "������ ����");

		// �ı⸦ ����� ���� �۾�
		BoardFactory boardfactory = new BoardFactory();
		BoardService boardservice = boardfactory.getBoardService();

		BoardDTO board = new BoardDTO("jang", "�ʹ����־��", "Ŀ�ǰ� ���־��");
		boardservice.insertBoard(board);

		BoardDTO board2 = new BoardDTO("bts", "�ʹ����־��", "Ŀ�ǰ� ���־��");
		boardservice.insertBoard(board2);

	}

}

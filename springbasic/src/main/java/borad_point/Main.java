package borad_point;

import customer.CustomerDTO;
import customer.CustomerService;
import customer.CustomerServiceImpl;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CustomerService service = new CustomerServiceImpl();
		// ������ ������ ���� ȣ��
		CustomerDTO customer = new CustomerDTO("jang","1234","�嵿��","GOLD");
		service.register(customer);
		System.out.println(customer.getName() + "������ ����");
		
		CustomerDTO customer2 = new CustomerDTO("bts","1234","��ź","VVIP");
		service.register(customer2);
		System.out.println(customer2.getName() + "������ ����");
		
		//�ı⸦ ����� ���� �۾�
		BoardService boardservice = new BoardServiceImpl();
		BoardDTO board = new BoardDTO("jang","�ʹ����־��","Ŀ�ǰ� ���־��");
		//BoardServiceImpl�� insertBoard������ CustomerDAO�� getUser()�޼ҵ带 �̿��ؼ� ���� ������ ��ȸ�Ѵ�. 
		//AbstractPoint��ü�� savePoint�ҵ带 �̿��Ͽ� ���޹��� ���� ������ grade������ Ȱ���ؼ�
		//����Ʈ�� �ο��ϵ��� ����
		boardservice.insertBoard(board);
		
		BoardDTO board2 = new BoardDTO("bts","�ʹ����־��","Ŀ�ǰ� ���־��");
		//BoardServiceImpl�� insertBoard������ CustomerDAO�� getUser()�޼ҵ带 �̿��ؼ� ���� ������ ��ȸ�Ѵ�. 
		//AbstractPoint��ü�� savePoint�ҵ带 �̿��Ͽ� ���޹��� ���� ������ grade������ Ȱ���ؼ�
		//����Ʈ�� �ο��ϵ��� ����
		boardservice.insertBoard(board2);
		
	}

}

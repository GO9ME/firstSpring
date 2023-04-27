package board_point.ver2;

import customer.ver2.CustomerDTO;
import customer.ver2.CustomerService;
import customer.ver2.CustomerServiceImpl;
import customer.ver2.CustomerFactory;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CustomerFactory factory = new CustomerFactory();
		// 서비스단의 메소드 호출 
		CustomerService service = factory.getCustomerService();
		// 데이터 삽입을 위한 호출
		CustomerDTO customer = new CustomerDTO("jang", "1234", "장동건", "GOLD");
		service.register(customer);
		System.out.println(customer.getName() + "데이터 저장");

		CustomerDTO customer2 = new CustomerDTO("bts", "1234", "방탄", "VVIP");
		service.register(customer2);
		System.out.println(customer2.getName() + "데이터 저장");

		// 후기를 남기기 위한 작업
		BoardFactory boardfactory = new BoardFactory();
		BoardService boardservice = boardfactory.getBoardService();

		BoardDTO board = new BoardDTO("jang", "너무맛있어요", "커피가 맛있어요");
		boardservice.insertBoard(board);

		BoardDTO board2 = new BoardDTO("bts", "너무맛있어요", "커피가 맛있어요");
		boardservice.insertBoard(board2);

	}

}

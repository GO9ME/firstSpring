package borad_point;

import customer.CustomerDTO;
import customer.CustomerService;
import customer.CustomerServiceImpl;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CustomerService service = new CustomerServiceImpl();
		// 데이터 삽입을 위한 호출
		CustomerDTO customer = new CustomerDTO("jang","1234","장동건","GOLD");
		service.register(customer);
		System.out.println(customer.getName() + "데이터 저장");
		
		CustomerDTO customer2 = new CustomerDTO("bts","1234","방탄","VVIP");
		service.register(customer2);
		System.out.println(customer2.getName() + "데이터 저장");
		
		//후기를 남기기 위한 작업
		BoardService boardservice = new BoardServiceImpl();
		BoardDTO board = new BoardDTO("jang","너무맛있어요","커피가 맛있어요");
		//BoardServiceImpl의 insertBoard에서는 CustomerDAO의 getUser()메소드를 이용해서 고객의 정보를 조회한다. 
		//AbstractPoint객체의 savePoint소드를 이용하여 전달받은 고객의 정보의 grade정보를 활용해서
		//포인트를 부여하도록 정의
		boardservice.insertBoard(board);
		
		BoardDTO board2 = new BoardDTO("bts","너무맛있어요","커피가 맛있어요");
		//BoardServiceImpl의 insertBoard에서는 CustomerDAO의 getUser()메소드를 이용해서 고객의 정보를 조회한다. 
		//AbstractPoint객체의 savePoint소드를 이용하여 전달받은 고객의 정보의 grade정보를 활용해서
		//포인트를 부여하도록 정의
		boardservice.insertBoard(board2);
		
	}

}

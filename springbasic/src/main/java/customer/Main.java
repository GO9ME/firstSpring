package customer;

public class Main {

	public static void main(String[] args) {
		// 서비스단의 메소드 호출 
		CustomerService service = new CustomerServiceImpl();
		// 데이터 삽입을 위한 호출
		CustomerDTO customer = new CustomerDTO("jang","1234","장동건","VVIP");
		service.register(customer);
		System.out.println(customer.getName() + "데이터 저장");
		
		CustomerDTO customer2 = new CustomerDTO("bts","1234","방탄","VVIP");
		service.register(customer2);
		System.out.println(customer2.getName() + "데이터 저장");
		
		// 데이터 조회를 위한 호출
		CustomerDTO finduser = service.read("bts");
		System.out.println("조회된 User : " + finduser);
	}

}

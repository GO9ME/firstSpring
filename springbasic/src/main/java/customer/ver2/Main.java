package customer.ver2;

public class Main {

	public static void main(String[] args) {
		// 사용하는 모든 객체의 생성을 관리하는 customerfactory객체에게 전달받아서 사용
		CustomerFactory factory = new CustomerFactory();
		// 서비스단의 메소드 호출 
		CustomerService service = factory.getCustomerService();
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

package customer.ver2;

//Customer와 관련된 객체를 생성해서 전닳해주는 외부객체 - 외부조립기(객체를 관리하는 컴ㅍ넌트를 컨테이너라 부름)
public class CustomerFactory {
	public CustomerDAO getCustomerDAO() {
		// 지금은 직접 new해서 생성하지만 설정파이릉ㄹ 만들고 설정파일을 읽어서 객체를 생성할 수 있도록 구현
		return new MyBatisCustomerDAO();
	}
	// 서비스 객체도 만들어서 리턴
	public CustomerService getCustomerService() {
		//CustomerDAO dao = getCustomerDAO();
		//CustomerDAO와 CustomerService를 직접 만들어서 리턴하고 있지만 주로 설정정보를 통해서 객체를
		//자동으로 만들 수 있도록 작업(코드를 가볍게 살펴보기 위해서 직접 만들어서 리턴)
//		CustomerDAO dao = new MyBatisCustomerDAO();
		
		CustomerService service = new CustomerServiceImpl(getCustomerDAO());
		return service;
	}
}

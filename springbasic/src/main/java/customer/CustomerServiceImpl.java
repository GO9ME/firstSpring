package customer;

/*
비지니스 로직
DB 데이터 가공
클라이언트 데이터 가공
논리적인 작업 단위
DAO의 메소드를 호출하는 역할
*/
public class CustomerServiceImpl implements CustomerService {
	// 내부에서 사용되는 구현클래스를 직접 코드로 정의
	CustomerDAO dao = new MyBatisCustomerDAO();
//  CustomerDAO dao = new JPACustomerDAO(); 
//	CustomerDAO dao = new SpringJDBCCustomerDAO();
	/*
	 * db연동 방법 JPA로 변경 => 구현 클래스 부분을 직접 소스에서 변경해야 함 OCP 원칙이 지켜지지 않음 : 기존에 자 실행되던 소스가
	 * CustomerServiceImple클래스 내부에서 CustomerDAO에만 의존해야 하는데 그렇지 않고 CustomerDAO의 하위인
	 * Spring JDBBCCustomerDAO에 의존하고 있음 즉, 상위 인터페이스에서도 의존하고 있고 상위인터페이스를 구현할 하위클래스에도
	 * 의존하고 있음 이는 DIP원칙이 지켜지지 않음 이렇게 상위와 하위클래스에 모두 의존하게 되면 코드가 변경될 수 밖에 없음
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

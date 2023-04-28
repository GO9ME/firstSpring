package annotation.exam01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("service")
public class ServiceImpl implements MyService {
	@Value("BTS")
	String name;
	
	@Value("멋있다")
	String msg;
	
	@Autowired
	Logic logic;

	public ServiceImpl() {
		// TODO Auto-generated constructor stub
		System.out.println("ServiceImpl의 기본생성자");
	}

	public ServiceImpl(String name, String msg, Logic logic) {
		super();
		this.name = name;
		this.msg = msg;
		this.logic = logic;
		System.out.println("ServiceImpl의 매개변수 세 개 생성자");
	}

	// Spring컨테이너가 객체를 만들고 Logic객체를 주입해 불 수 있또록 생성자 준비하기
	@Override
	public void testService() {
		System.out.println(msg + "," + name);
		logic.testLogic();
	}

}

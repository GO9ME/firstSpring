package app1;

/*
	결합도가 극도로 높은 프로그램
	=> 클래스 결합도가 높고 의존성도 높음
	사용하는 클래스가 변경되면 이 클래스를 사용하는 모든 곳의 코드를 수정해야함
	OOP특성이 적용 되지 않음 
	상위 인터페이스와 구현체로 분리하지 않음
	다형성이 적용되지 않았음 

*/
public class MyBeanTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		MyBeanStyleB obj = new MyBeanStyleB();
		MyBeanStyleA obj = new MyBeanStyleA();
		run(obj);
		show(obj);
	}
	public static void run( MyBeanStyleA obj) {
		System.out.println("=========================");
		obj.testHello("BTS");
		System.out.println("=========================");
	}
	public static void show(MyBeanStyleA obj) {
		obj.testHello("BTS");
		obj.testHello("BTS");
		obj.testHello("BTS");
		obj.testHello("BTS");
		obj.testHello("BTS");
		obj.testHello("BTS");
	}
}

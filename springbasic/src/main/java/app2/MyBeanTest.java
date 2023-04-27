package app2;

/*
	oop 특성을 적용해서 소스를 변경
*/
public class MyBeanTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyBean obj = new MyBeanStyleA();
//		MyBean obj2 = new MyBeanStyleA();
		run(obj);
		show(obj);
//		run(obj2);
//		show(obj2);
	}
	public static void run( MyBean obj) {
		System.out.println("=========================");
		obj.testHello("BTS");
		System.out.println("=========================");
	}
	public static void show(MyBean obj) {
		obj.testHello("BTS");
		obj.testHello("BTS");
		obj.testHello("BTS");
		obj.testHello("BTS");
		obj.testHello("BTS");
		obj.testHello("BTS");
	}
}

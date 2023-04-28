package app4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*

*/
public class MyBeanTest_spring_ApplicationContext {
	public static void main(String[] args) {
		// 1. IoC컨테이너를 생성 - Application Context
		ApplicationContext factory = new ClassPathXmlApplicationContext("/config/bean.xml");
		// 원하는 객체를 loop
		MyBean obj =  (MyBean) factory.getBean("mybean"); // 빈을 등록할때 정의한 id 명을 사용
		run(obj);
		show(obj);
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

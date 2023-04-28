package app4;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import app3.MyBean;

/*

*/
public class MyBeanTest_spring_ApplicationContext {
	public static void main(String[] args) {
		// 1. xml 파싱
		Resource res = new ClassPathResource("/config/bean.xml");
		// 2. 스프링이 제공한 IoC컨테이너(객체를 생성하고 관리하는 기능을 갖고 있는 클래스)를 생성
		BeanFactory factory = new XmlBeanFactory(res);
		// 3. 원하는 객체를 look up
		MyBean obj = (MyBean) factory.getBean("mybean");
		
		
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

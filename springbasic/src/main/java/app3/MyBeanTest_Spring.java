package app3;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

/*
	스프링의 IoC컨테이너를 이용해서 작업하기
	- 스프링은 설정파일(XML형식, Bean)이 필요
	- BeanFactory 사용
	1. xml파싱(xml로 만들어진 설정 파일을 파싱해서 스프링에서 제공되는 객체를 이용)
	2. Factory클래스를 생성 
	3. Factory 클래스에서 제공하는 객체를 찾기 
*/
public class MyBeanTest_Spring {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. xml 파싱
		Resource res = new ClassPathResource("/config/bean.xml");
		// 2. 스프링이 제공하는 IoC컨테이너 (객체를 생성하고 관리하는 기능을 갖고 있는 클래스)를 생성
		BeanFactory factory = new XmlBeanFactory(res);
		// 3. 원하는 객체를 lookup
		
		MyBean obj =  (MyBean) factory.getBean("mybean"); // 빈을 등록할때 idauddmf tkdyd
		
		
		
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

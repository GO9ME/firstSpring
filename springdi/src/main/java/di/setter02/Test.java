package di.setter02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("/config/setter.xml");
		ServiceImpl obj  = (ServiceImpl) factory.getBean("service");
		obj.testService();

	}

}

package exam01;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class TVUser {
	public static void main(String[] args) {
		
		Resource res = new ClassPathResource("/config/bean.xml");
		BeanFactory factory = new XmlBeanFactory(res);
		
		TV tv =  (TV) factory.getBean("lgtv"); // ���� ����Ҷ� idauddmf tkdyd
		TV lgtv =  (TV) factory.getBean("sstv"); // ���� ����Ҷ� idauddmf tkdyd
		tv.turnOn();
		tv.soundUp();
		tv.soundDown();
		tv.turnOff();
		
		lgtv.turnOn();
		lgtv.soundUp();
		lgtv.soundDown();
		lgtv.turnOff();
	}

}

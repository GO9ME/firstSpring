package app3;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

/*
	�������� IoC�����̳ʸ� �̿��ؼ� �۾��ϱ�
	- �������� ��������(XML����, Bean)�� �ʿ�
	- BeanFactory ���
	1. xml�Ľ�(xml�� ������� ���� ������ �Ľ��ؼ� ���������� �����Ǵ� ��ü�� �̿�)
	2. FactoryŬ������ ���� 
	3. Factory Ŭ�������� �����ϴ� ��ü�� ã�� 
*/
public class MyBeanTest_Spring {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. xml �Ľ�
		Resource res = new ClassPathResource("/config/bean.xml");
		// 2. �������� �����ϴ� IoC�����̳� (��ü�� �����ϰ� �����ϴ� ����� ���� �ִ� Ŭ����)�� ����
		BeanFactory factory = new XmlBeanFactory(res);
		// 3. ���ϴ� ��ü�� lookup
		
		MyBean obj =  (MyBean) factory.getBean("mybean"); // ���� ����Ҷ� idauddmf tkdyd
		
		
		
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

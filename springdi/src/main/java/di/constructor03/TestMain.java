package di.constructor03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext factory = new ClassPathXmlApplicationContext("/config/constructor.xml");
		IWriteArticleMgr iwam = (IWriteArticleMgr) factory.getBean("article");
		ArticleDTO dto = new ArticleDTO("jang","오라클","테스트","2023-04-28");
		iwam.write(dto);
	}
}

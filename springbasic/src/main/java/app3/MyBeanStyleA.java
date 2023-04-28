package app3;

public class MyBeanStyleA implements MyBean{
	public MyBeanStyleA() {
		// TODO Auto-generated constructor stub
		System.out.println("MyBeanStyleA 생성");
	}
	@Override
	public void testHello(String name) {
		// TODO Auto-generated method stub
		System.out.println("�ȳ��ϼ���" + name + "��!!!");
	}
	
}

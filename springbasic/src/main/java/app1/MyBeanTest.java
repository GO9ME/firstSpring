package app1;

/*
	���յ��� �ص��� ���� ���α׷�
	=> Ŭ���� ���յ��� ���� �������� ����
	����ϴ� Ŭ������ ����Ǹ� �� Ŭ������ ����ϴ� ��� ���� �ڵ带 �����ؾ���
	OOPƯ���� ���� ���� ���� 
	���� �������̽��� ����ü�� �и����� ����
	�������� ������� �ʾ��� 

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

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
		MyBeanStyleB obj = new MyBeanStyleB();
		run(obj);
		show(obj);
	}
	public static void run( MyBeanStyleB obj) {
		System.out.println("=========================");
		obj.testHello2("BTS");
		System.out.println("=========================");
	}
	public static void show(MyBeanStyleB obj) {
		obj.testHello2("BTS");
		obj.testHello2("BTS");
		obj.testHello2("BTS");
		obj.testHello2("BTS");
		obj.testHello2("BTS");
		obj.testHello2("BTS");
	}
}

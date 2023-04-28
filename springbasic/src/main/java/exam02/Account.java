package exam02;


public class Account {
	private String accId;
	private long balance=1000000;
	public Account() {
		// TODO Auto-generated constructor stub
		System.out.println("Account 객체 생성");
	}
	
	public void setAccId(String accId){
		this.accId = accId;
	}
	public String getAccId(){
		return this.accId;
	}
	//�엯湲덊븯湲�
	public void input(long money){
		balance = balance+money;
	}
	//異쒓툑�븯湲�
	public void output(long money){
		balance = balance-money;
	}
	//�옍�븸議고쉶�븯湲�
	public long getBalance(){
		return balance;
	}
}

package ch12;

public class Mom extends Thread{
	private Account account;
	
	Mom(Account account){
		this.account = account;
	}
	
	public void run() {
		for(int i=0;i<10;i++) {
			account.setMoney();
		}
	}
}

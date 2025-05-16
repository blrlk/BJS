package ch11;

public class Son extends Thread{
	private Account account;
	
	Son(Account account){
		this.account = account;
	}
	
	public void run() {
		for(int i=0;i<10;i++) {
			account.getMoney();
		}
	}

}

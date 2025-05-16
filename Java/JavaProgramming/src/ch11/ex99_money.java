package ch11;

public class ex99_money {

	public static void main(String[] args) {
		Account account = new Account();
		Son son = new Son(account);
		Mom mom = new Mom(account);
		
		//스레드는 실행 순서 보장 x
		son.start();
		mom.start();
	}

}

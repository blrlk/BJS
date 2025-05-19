package ch12;

public class Account {
	int money = 0;
	
	//입출금
	public int showMoney() {
		return money;
	}
	
	//synchronized: 한 번에 하나의 스레드만 코드에 접근할 수 있도록 잠금 설정
	public synchronized void setMoney() {
		try {
			Thread.sleep(1000);
		} catch(InterruptedException ie) {
			System.out.println(ie.toString());
		}
		
		this.money+=2000;
		
		System.out.println("어머니 용돈 입금. 현재 잔액: "+this.showMoney());
		
		//wait 상태의 thread 깨우기
		//여기서는 엄마가 아들 깨움
		this.notify();
	}
	
	public synchronized void getMoney() {
		while(money<=0) {
			try {
				System.out.println("통장 잔고가 없어서 아들 대기 중");
				//아들 대기
				this.wait();
			} catch(InterruptedException e) {
				System.out.println("오류");
			}
		}

		this.money-=2000;
		System.out.println("아들 용돈 출금. 현재 잔액: "+this.showMoney());
	}
}

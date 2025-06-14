package ch12;

class MyThreadB implements Runnable{
	Ticketing ticket = new Ticketing();
	public void run() {
		ticket.ticketing();
	}
}

class Ticketing{
	int ticketNumber = 1;
	public void ticketing() {
		if(ticketNumber>0) {
			System.out.println(Thread.currentThread().getName()+"가 티켓팅 성공");
			ticketNumber -=1;			
		} else {
			System.out.println(Thread.currentThread().getName()+"가 티켓팅 실패");
		}
		System.out.println(Thread.currentThread().getName()+"가 티켓팅 시도 후 남은 티켓"+ticketNumber);
	}
}

public class ex98_synchronized1 {

	public static void main(String[] args) {
		MyThreadB s1 = new MyThreadB();
		Thread t1 = new Thread(s1, "A");
		Thread t2 = new Thread(s1, "B");
		Thread t3 = new Thread(s1, "C");
		
		t1.start();
		t2.start();
		t3.start();
	}

}

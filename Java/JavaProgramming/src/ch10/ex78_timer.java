package ch10;

import java.util.Timer;
import java.util.TimerTask;

class Work1 extends TimerTask{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("work1 실행");
	}
	
}

class Work2 extends TimerTask{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("work2 실행");
	}


	
}

public class ex78_timer {

	public static void main(String[] args) throws InterruptedException {
		Timer t = new Timer(true);
		TimerTask w1 = new Work1();
		TimerTask w2 = new Work2();
		
		t.schedule(w1, 3000);
		t.schedule(w2, 1000);
		
		Thread.sleep(4000);
		System.out.println("모든 작업 종료");
	}

}

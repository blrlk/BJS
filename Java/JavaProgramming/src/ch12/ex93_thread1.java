package ch12;

class MyThread extends Thread{
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println("스레드 진행 중 "+ i);
		}
	}
}

class Mythread2 implements Runnable{
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println("러너블 진행 중 "+i);
		}
	}
}

public class ex93_thread1 {

	public static void main(String[] args) {
		MyThread th1 = new MyThread();
		Runnable th2 = new Mythread2();
		Thread t = new Thread(th2);
		th1.start();
		t.start();
		for(int i=0;i<10;i++) {
			System.out.println("메인 함수 진행 중 "+i);
		}
		
	}

}

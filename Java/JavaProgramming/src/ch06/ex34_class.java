package ch06;

class Cars{
	static int wheel = 4;
	int speed;
}


public class ex34_class {

	public static void main(String[] args) {
		System.out.println(Cars.wheel);
		
		Cars mycar1 = new Cars();
		System.out.println(mycar1.wheel);
		System.out.println(mycar1.speed);
		
		Cars mycar2 = new Cars();
		
		System.out.println("<변경 전>");
		System.out.println("mycar1.speed: "+mycar1.speed);
		System.out.println("mycar2.speed: "+mycar2.speed);
		System.out.println("mycar1.wheel: "+mycar1.wheel);
		System.out.println("mycar2.wheel: "+mycar2.wheel);
		
		mycar2.speed = 100;
		mycar2.wheel = 5;
		
		System.out.println("<변경 후>");
		System.out.println("mycar1.speed: "+mycar1.speed);
		System.out.println("mycar2.speed: "+mycar2.speed);
		System.out.println("mycar1.wheel: "+mycar1.wheel);
		System.out.println("mycar2.wheel: "+mycar2.wheel);
		
	}

}

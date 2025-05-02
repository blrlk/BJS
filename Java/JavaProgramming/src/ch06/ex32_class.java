package ch06;

class Car{
	boolean powerOn;
	String color;
	int wheel;
	int speed;
	boolean wiperOn;
	
	void power() {powerOn = !powerOn;}
	void speedUp() {speed++;}
	void speedDown() {speed--;}
	void wiper() {wiperOn = !wiperOn;}
}


public class ex32_class {

	public static void main(String[] args) {
		Car mycar = new Car();
		
		
	}

}

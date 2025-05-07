package ch06;

public class Car {
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
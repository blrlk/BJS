package ch06;

class Cellphone{
	String model = "Galaxy8";
	String color;
	int capacity;
	
	Cellphone(String color, int capacity){
		this.color = color;
		this.capacity = capacity;
	}
}


public class ex39_constructor {
	
	public static void main(String[] args) {
		Cellphone myphone = new Cellphone("black", 64);
		Cellphone myphone2 = new Cellphone("silver", 32);
		
		System.out.printf("%s %s %d\n", myphone.model, myphone.color, myphone.capacity);
		System.out.printf("%s %s %d\n", myphone2.model, myphone2.color, myphone2.capacity);
		
	}

}

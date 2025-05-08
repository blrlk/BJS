package ch07;

//class Person{
//	void breath() {
//		System.out.println("숨쉬기");
//	}
//	
//	void eat() {
//		System.out.println("밥먹기");
//	}
//	
//	void say() {
//		System.out.println("말하기");
//	}
//}
//
//class Student extends Person{
//	void learn() {
//		System.out.println("배우기");
//	}
//}
//
//class Teacher extends Person{
//	void teach() {
//		System.out.println("가르치기");
//	}
//}

public class ex40_inheritance {
	
	public static void main(String[] args) {
		Student s1 = new Student();
		s1.eat();
		s1.learn();
		
		Teacher s2 = new Teacher();
		s2.say();
		s2.teach();
	}

}

package ch07;

//1
//public class User {
//	public String name;
//	public int age;
//	
//	User(String name, int age){
//		this.name = name;
//		this.age = age;
//	}
//}

//2
public class User {
	private String name;
	private int age;
	
	User(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}
}

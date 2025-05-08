package ch07;

public class ex46_accessModifier1 {

	public static void main(String[] args) {
//		User user1 = new User("철수", 20);
		User user2 = new User("영희", 19);
		
		//1
//		System.out.println(user2.name + "의 나이는 "+user2.age);
//		user2.age = 99;
//		System.out.println(user2.name + "의 나이는 "+user2.age);
		
		//2
		user2.setAge(20);
		System.out.println(user2.getName() + "의 나이는 " + user2.getAge());
		
		
	}

}

package dto;

public class member {
	private String name;
	private int age;
	
	//tostring
	@Override
	public String toString() {
		return "member [name=" + name + ", age=" + age + "]";
	}

	//getter/setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	//constructor
	public member(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public member() {
	}
	
	
	
}

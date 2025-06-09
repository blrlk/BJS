package DTO;
// dto의 변수 항상 private
// 기본생성자, 전체생성자, toString, getter/setter

public class member {
	private String id;
	private String pwd;
	private String name;
	
	//기본 생성자
	public member() {

	}

	//전체 생성자
	public member(String id, String pwd, String name) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
	}
	
	//toString
	@Override
	public String toString() {
		return "member [id=" + id + ", pwd=" + pwd + ", name=" + name + "]";
	}

	//getter, setter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
}

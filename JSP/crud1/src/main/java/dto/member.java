package dto;

public class member {
	private String id;
	private String pwd;
	
	//getter/setter
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
	
	//constructor
	public member(String id, String pwd) {
		this.id = id;
		this.pwd = pwd;
	}
	public member() {
	}
	
	//tostring
	@Override
	public String toString() {
		return "member [id=" + id + ", pwd=" + pwd + "]";
	}
	
}

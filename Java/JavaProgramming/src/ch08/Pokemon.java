package ch08;

abstract class Pokemon {
	String name;
	
	abstract void attack();
	abstract void sound();
	
	
	public String getName() {
		return this.name;
	}
	
	

}
package ch08;

public class Squirtle extends Pokemon{
	Squirtle(){
		this.name = "꼬부기";
	}

	@Override
	void attack() {
		System.out.println("물 공격");
	}

	@Override
	void sound() {
		System.out.println("꼬북꼬북");
	}
	
	
}

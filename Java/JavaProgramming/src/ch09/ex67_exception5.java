package ch09;

class AgeException extends Exception{
	public AgeException() {}
	public AgeException(String message) {
		super(message);
	}
}

public class ex67_exception5 {
	
	public static void ticketing(int age) throws AgeException{
		if(age<0) {
			throw new AgeException("나이 입력 잘못됨");
		}
	}
	
	public static void main(String[] args) {
		int age = -19;
		try {
			ticketing(age);
		} catch(AgeException e) {
			e.printStackTrace();
		}
	}

}

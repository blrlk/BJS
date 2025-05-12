package ch07;

public class ex58_anonymous {

	public static void main(String[] args) {
		outerClass outer = new outerClass() {
			void a() {
				System.out.println("anonymous method a");
			}
		};
		
		outer.a();
		
		outerClass outer1 = new outerClass();
		outer1.a();
	}

}

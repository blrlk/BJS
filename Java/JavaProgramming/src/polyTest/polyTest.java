package polyTest;

public class polyTest {

	public static void main(String[] args) {
		sub sb = new sub();
		P a = new A();
		B b = new B();
		P c = new C();
		System.out.println("A");
		sb.process(a);
		System.out.println("B");
		sb.process(b);
		System.out.println("C");
		sb.process(c);
	}

}
package ch10;

//StringBuffer() - 문자열을 수정할 수 있는 가변 객체
public class stringbuffer {

	public static void main(String[] args) {
		String a = "java";
		String b = "Hello";
		System.out.println("a: "+a.hashCode());	//hashCode(): 문자열 내용을 기반으로 계산된 정수값 - 내용이 같으면 hashCode 같음
		System.out.println("b: "+b.hashCode());
		a = a+b;	//문자열 덧셈 -> javaHello
		System.out.println("a: "+a.hashCode());
		
		StringBuffer c = new StringBuffer();	//문자열 수정 가능 객체
		System.out.println("c: "+c.hashCode());
		c.append(2);
		c.append("+");
		c.append(3);
		c.append("=");
		c.append(5);
		System.out.println(c);
		c.append("TEST StringBuffer");
		System.out.println("c: "+c.hashCode());	//가변 객체라 내용이 바뀌어도 hashCode는 변하지 않음
	}

}

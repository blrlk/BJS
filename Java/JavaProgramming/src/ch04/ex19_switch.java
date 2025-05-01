package ch04;

public class ex19_switch {

	public static void main(String[] args) {
		int book = 2;
		book /= 10;
		switch (book) {
		case 0:
			System.out.println("조금 더 노력하세요");
//			break;
		case 1:
			System.out.println("독서를 즐기시는군요");
//			break;
		case 2:
			System.out.println("책을 사랑하시네");
//			break;
		default:
			System.out.println("다독왕");
		}
	}

}

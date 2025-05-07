package ch06;

public class ex37_method3 {
	int a = 10;	//instance 변수

	// static -> instance
	public static void main(String[] args) {
//		System.out.println(a); // 오류, 이 위치에서는 a가 존재하지 않음
		// 여기서는 객체를 생성해주어야 ex37_method의 요소 접근 가능
		ex37_method3 x = new ex37_method3();
		System.out.println(x.a);

		// static은 절대 instance 참조 xxx
//		Check.cm_Imember();	//오류
		Check.cm_Cmember();

		Check myinstance = new Check();
		myinstance.im_Cmember();
		myinstance.im_Imember();

	}

	// instance -> instance
	public void main2() {
		System.out.println(a); // 오류 x, main2도 존재하지 않기 때문에 문제 x
	}

}

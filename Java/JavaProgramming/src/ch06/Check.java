package ch06;

public class Check {
	static int cv = 5;
	int iv = 4;
	static void cm() {}
	void im() {}
	
	// 항상 인스턴스가 생성되는 것은 아님
	
	// 존재하는 것이 존재하지 않는 것을 호출 -> 오류
	// 생성이 안 될 수도 있으니 참조할 수 없음
	static void cm_Imember() {
//		System.out.println(iv);
//		im();
	}
	
	// 존재하는 것이 존재하는 것을 호출 -> 오류 x
	static void cm_Cmember() {
		System.out.println(cv);
		cm();
	}
	
	// 존재하지 않는 것이 존재하는 것을 호출 -> 오류 x
	// 호출하는 부분만 존재하면 오류 안 남
	// 생성이 안 될 시에도 문제 없음
	void im_Cmember() {
		System.out.println(cv);
		cm();
	}
	
	// 존재하지 않는 것이 존재하지 않는 것을 호출 -> 오류 x
	// 인스턴스 생성이 안 될 시에도 상관 없음
	void im_Imember() {
		System.out.println(iv);
		im();
	}
}

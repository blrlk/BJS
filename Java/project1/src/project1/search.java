//search
package project1;

import java.util.ArrayList;

public class search {
	ArrayList arr;
	
	public void onesearch() {}
	
	public void allsearch() {
		//getRepo가 static이라 객체 생성 없이도 사용 가능
		arr = repository.getRepo();
		
		System.out.println("전체 회원 목록");
		
		//length가 아니라 size()로 
		for(int i=0;i<arr.size();i++) {
			car tmp = (car)arr.get(i);
			System.out.println("-----------------");			
			System.out.println("구매자: "+tmp.user);
			System.out.println("전화번호: "+tmp.phone);
			System.out.println("차종: "+tmp.name);
			System.out.println("금액: "+tmp.price);
			System.out.println("색상: "+tmp.color);
		}
	}
}

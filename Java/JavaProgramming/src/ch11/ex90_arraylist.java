package ch11;

import java.util.*;

public class ex90_arraylist {

	public static void main(String[] args) {
		//ArrayList list1 = new ArrayList(10);
		ArrayList<String> list1 = new ArrayList<String>(10);
		list1.add("A");
		list1.add("C");
		list1.add("E");
		list1.add("D");
		System.out.println("초기 상태 "+ list1);

		list1.add(1, "B");
		System.out.println("인덱스 1에 B 추가 "+list1);
		
		list1.remove(2);
		System.out.println("인덱스 2 삭제 "+list1);
		
		System.out.println("list1[2] = "+list1.get(2));
	}

}

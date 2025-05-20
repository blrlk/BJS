package test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

class member{
	String name;
	int age;
	member(String name, int age){
		this.name = name;
		this.age = age;
	}
}

public class test0520{

	public static void main(String[] args) {
		ArrayList arrlist = new ArrayList();
		member mb1 = new member("광수", 40);
		member mb2 = new member("민수", 30);
		
		arrlist.add(mb1.name);
		arrlist.add(mb1.age);
		
		int sec = (int)arrlist.get(1);
		
		System.out.println(sec);
		
	}

}

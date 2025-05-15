package ch10;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ex80_format2 {

	public static void main(String[] args) {
		Date day = new Date();
		System.out.println("현재 날짜:"+day);
		
		String ptnKorea = "yyyy-MM-dd";
		SimpleDateFormat p1 = new SimpleDateFormat(ptnKorea);
		System.out.println("한국 형식(년,월,일): "+p1.format(day));
		
		String ptnUSA = "MM-dd-yyyy";
		SimpleDateFormat p2 = new SimpleDateFormat(ptnUSA);
		System.out.println("미국 형식(월,일,년): "+p2.format(day));
		
		String ptnUK = "dd-MM-yyyy";
		SimpleDateFormat p3 = new SimpleDateFormat(ptnUK);
		System.out.println("영국 형식(일,월,년): "+p3.format(day));
		
		String ptn1 = "E요일 HH시 mm분 ss초";
		SimpleDateFormat p4 = new SimpleDateFormat(ptn1);
		System.out.println(p4.format(day));
	}

}

package ch10;

import java.util.Calendar;

public class ex70_date2 {

	public static void main(String[] args) {
		Calendar a = Calendar.getInstance();
		
		int year = a.get(Calendar.YEAR);
		int month = a.get(Calendar.MONTH);
		int date = a.get(Calendar.DATE);
		
		System.out.println(year + "년" + (month+1) + "월" + date + "일");
		System.out.println(a.get(Calendar.DAY_OF_WEEK));	//일요일: 1
		System.out.println(a.getActualMaximum(Calendar.DATE));	//이번 달은 며칠까지 있는가
	}

}

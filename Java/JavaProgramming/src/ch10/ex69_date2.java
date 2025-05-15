package ch10;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class ex69_date2 {

	public static void main(String[] args) {
		Calendar a = Calendar.getInstance();
		Calendar b = new GregorianCalendar();
		System.out.println(a.toString());
		System.out.println(b.toString());	
	}

}

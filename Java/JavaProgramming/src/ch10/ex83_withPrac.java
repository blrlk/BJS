package ch10;

import java.time.*;

public class ex83_withPrac {

	public static void main(String[] args) {
		LocalDate ld = LocalDate.now();
		System.out.println(ld);
		
		LocalDate new_ld = ld.withYear(1999).withMonth(8).withDayOfYear(23);
		System.out.println(new_ld);
	}

}

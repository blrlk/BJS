package ch10;

import java.time.*;

public class ex81_timeplus {

	public static void main(String[] args) {
		LocalDate ld = LocalDate.now();
		System.out.println(ld);
		
		LocalDate ld2 = ld.minusYears(2).plusMonths(3).minusDays(4);
		System.out.println(ld2);
		
		//자동 변환
		LocalDate ld3 = ld2.minusDays(3);
		System.out.println(ld3);
		
		//주 더하기
		LocalDate ld4 = ld3.plusWeeks(3);
		System.out.println(ld4);
	}

}

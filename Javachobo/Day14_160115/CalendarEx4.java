package Day14_160115;

import java.util.*;

import Day9_160108.ToStringTest;

public class CalendarEx4 {
	public static void main(String[] args) {
		Calendar date = Calendar.getInstance();

		date.set(2005, 7, 31);// 2005년 8월 31일

		System.out.println(toString(date));
		System.out.println("= 1일 후 =");
		date.add(Calendar.DATE, 1);
		System.out.println(toString(date));

		System.out.println("= 6달 전 =");
		date.add(Calendar.MONTH, -6);
		System.out.println(toString(date));

		System.out.println("= 31일 후(roll) =");
		date.roll(Calendar.DATE, 31);
		// add메소드와 비슷하나 MONTH에는 영향을 미치지 않아 그 달이 지나면 다음달로 넘어가지 않고 날짜만 증가
		// 따라서 2005년4월1일로 출력되어야하지만 2005년3월1일로 출력됨
		System.out.println(toString(date));

		System.out.println("= 31일 후(add) =");
		date.add(Calendar.DATE, 31);
		System.out.println(toString(date));
	}

	public static String toString(Calendar date) {

		return date.get(Calendar.YEAR) + "년" + (date.get(Calendar.MONTH) + 1) + "월" + date.get(Calendar.DATE) + "일";
	}
}

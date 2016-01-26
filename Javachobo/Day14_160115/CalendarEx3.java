package Day14_160115;

import java.util.*;

public class CalendarEx3 {
	public static void main(String[] args) {
		final int[] TIME_UNIT = { 3600, 60, 1 };// 큰 단위를 앞에 놓는다.
		final String[] TIME_UNIT_NAME = { "시간", "분", "초" };

		Calendar time1 = Calendar.getInstance();
		Calendar time2 = Calendar.getInstance();

		// time1의 시간을 10시20분30초로 설정한다.
		time1.set(Calendar.HOUR_OF_DAY, 10);
		time1.set(Calendar.MINUTE, 20);
		time1.set(Calendar.SECOND, 30);

		// time2의 시간을 20시30분10초로 설정한다.
		time2.set(Calendar.HOUR_OF_DAY, 20);
		time2.set(Calendar.MINUTE, 30);
		time2.set(Calendar.SECOND, 10);

		System.out.println("time1 : " + time1.get(Calendar.HOUR_OF_DAY) + "시 " + time1.get(Calendar.MINUTE) + "분"
				+ time1.get(Calendar.SECOND));
		System.out.println("time2 : " + time2.get(Calendar.HOUR_OF_DAY) + "시 " + time2.get(Calendar.MINUTE) + "분"
				+ time2.get(Calendar.SECOND));

		long difference = Math.abs(time2.getTimeInMillis() - time1.getTimeInMillis()) / 1000;// Math.abs();절대값구하는메서드
		System.out.println("time1과 time2의 차이는 " + difference + "초입니다.");

		String tmp = "";
		for (int i = 0; i < TIME_UNIT.length; i++) {// 시분초로바꿔주는
			tmp += difference / TIME_UNIT[i] + TIME_UNIT_NAME[i] + " ";
			difference %= TIME_UNIT[i];
			System.out.print(tmp);
			System.out.println(difference);
		}
		System.out.println("시분초로 변환하려면 " + tmp + "입니다.");
	}
}

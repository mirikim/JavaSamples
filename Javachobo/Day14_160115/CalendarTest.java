package Day14_160115;

import java.io.*;
import java.util.*;
import java.lang.*;

public class CalendarTest {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		mainLoop: while (true) {
			System.out.println("=========================== 달력프로그램시작 ===========================");
			try {
				System.out.print("년도를 입력해주세요 : ");
				int year = Integer.parseInt(in.readLine());

				if (year < 1900) {
					System.out.println("해당 달력이 존재하지 않습니다.1900년도 이후를 입력해주세요.");

				} else {
					MonthArray(year);
					
					System.out.println("");
					System.out.println("프로그램종료 - '1' , 계속 - '2'        :");
					int manual = Integer.parseInt(in.readLine());
					switch (manual) {
					case 1:
						break mainLoop;
						
					case 2:
						break;

					default:
						throw new Exception();

					}
				}
			} catch (Exception e) {
				System.out.println("에러 발생!");
			}
		} // mainLoop종료
		System.out.println("=========================== 달력프로그램종료 ===========================");
	}

	static void MonthArray(int year) {
		String Month12[][] = new String[12][6];
		for (int month = 1; month < 13; month++) {
			int START_DAY_OF_WEEK = 0;
			int END_DAY = 0;
			String monthDate[] = { "", "", "", "", "", "" };

			Calendar sDay = Calendar.getInstance();// 시작일
			Calendar eDay = Calendar.getInstance();// 끝일

			// 월의 경우 0부터 11까지의 값을 가지므로 1을 빼주어야 한다.
			// 예를 들어, 2004년 11월 1일은 sDay.set(2004,10,1);과 같이 해줘야 한다.

			sDay.set(year, month - 1, 1);
			eDay.set(year, month, 1);

			// 다음달의 첫날에서 하루를 빼면 현재달의 마지막 날이 된다.
			// 12월 1일에서 하루를 빼면 11월 30일이 된다.
			eDay.add(Calendar.DATE, -1);

			// 첫 번재 요일이 무슨 요일인지 알아낸다.
			START_DAY_OF_WEEK = sDay.get(Calendar.DAY_OF_WEEK);
			// eDay에 지정된 날짜를 얻어온다.
			END_DAY = eDay.get(Calendar.DATE);

			// 해당 월의 1일이 어느 요일인지에 따라서 공백을 출력한다.
			// 만일 1일이 수요일이라면 공백을 세 번 찍는다. (일요일부터 시작)

			for (int i = 1; i < START_DAY_OF_WEEK; i++) {

				monthDate[0] += "   ";

			}

			int day = 1;
			for (int k = START_DAY_OF_WEEK - 1; k < 7; k++) {
				monthDate[0] += (((day < 10) ? "  " + day : " " + day));
				++day;

			}

			int l = 1;
			int k = 0;
			for (int date = day; date <= END_DAY; date++) {

				monthDate[l] += (((date < 10) ? "  " + date : " " + date));
				k++;
				if (k % 7 == 0) {
					l++;
					k = 0;
				}

			}
			String lastline = monthDate[4];
			if (!(lastline.length() == 21)) {

				for (int last = k; last < 7; last++) {

					monthDate[4] += "   ";
				}
			} // 마지막주 날짜에 공백 넣기
			for (int j = 0; j < 6; j++) {
				Month12[month - 1][j] = monthDate[j];
			}
		} // MonthArray method끝

		for (int quarter = 0; quarter < 4; quarter++) {

			System.out.println();
			for (int i = 1; i < 4; i++) {
				System.out.print("      " + year + "년"
						+ (((quarter * 3 + i) < 10) ? "  " + (quarter * 3 + i) : " " + (quarter * 3 + i)) + "월       ");
			}
			System.out.println();
			System.out.println(" SU MO TU WE TH FR SA   SU MO TU WE TH FR SA   SU MO TU WE TH FR SA");
			for (

			int i = 0; i < 6; i++)

			{

				System.out.print(Month12[quarter * 3][i]);
				System.out.print("  ");
				System.out.print(Month12[quarter * 3 + 1][i]);
				System.out.print("  ");

				System.out.print(Month12[quarter * 3 + 2][i]);

				System.out.println();
			}

		} // 달력 출력
	}// Month12[][]생성

}

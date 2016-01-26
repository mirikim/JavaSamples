package Day17_160120;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TelAndAge {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("[1 : 프로그램 시작 , 2 : 프로그램 종료] 번호를 입력해주세요 :");
			int Input = sc.nextInt();
			switch (Input) {
			case 1:
				GuessTelAndAge();
				break;

			case 2:
			default:
				System.out.println("===================== 프로그램 종료 =====================");
				System.exit(0);
			} // switch
		} // while
	}// main

	static void GuessTelAndAge() {
		Scanner sc = new Scanner(System.in);
		System.out.println("===================== 프로그램 시작 =====================");
		System.out.println("*   핸드폰 번호 뒷 네자리와 나이 추측 프로그램입니다.   *");
		System.out.println("=========================================================");
		System.out.println();

		System.out.print("(1) 당신의 휴대폰 번호 뒷 네자리를 입력하세요. : ");
		int InputTel = sc.nextInt();

		int cal = InputTel * 2;
		System.out.println("(2) 입력된 휴대폰 번호 뒷 네자리에 2를 곱한다. : " + cal);
		cal = cal + 5;
		System.out.println("(3) 다시 더하기 5를 한다. : " + cal);
		cal = cal * 50;
		System.out.println("(4) 다시 곱하기 50을 한다. : " + cal);
		cal = cal + 1765;
		System.out.println("(5) 다시 더하기 1766를 한다. : " + cal);
		System.out.print("    그리고 당신의 태어난 년도를 입력해주세요. : ");
		int InputYear = sc.nextInt();
		cal = cal - InputYear;
		System.out.println("(6) 앞에서 계산된 값에 태어난 년도를 뺀다. : " + cal);
		String StrCal = cal + "";

		String tel = "";
		String age = "";
		for (int i = 0; i < 4; i++) {
			tel += StrCal.charAt(i);
		}
		for (int i = 4; i < 6; i++) {
			age += StrCal.charAt(i);
		}

		System.out.println("=========================================================");
		System.out.println("*                                                       *");
		System.out.println("            휴대폰 번호 : " + tel + ",   나이 : " + age);
		System.out.println("*                                                       *");
		System.out.println("=====================   추측 종료   =====================");
		System.out.println();
	}
}

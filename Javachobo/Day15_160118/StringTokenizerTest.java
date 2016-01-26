package Day15_160118;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class StringTokenizerTest {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("========================프로그램 시작========================");
		mainLoop: while (true) {
			System.out.println("프로그램을 선택해주세요.");
			System.out.println("'1' : 숫자->한글  '2' : 한글 ->숫자 '3' :종료");
			int programNum = Integer.parseInt(in.readLine());
			switch (programNum) {
			case 1:
				System.out.print("변환 할 값을 입력해주세요.(ex 4,982,000) : ");
				String input = in.readLine();

				numTohangul(input);
				break;
			case 2:

				System.out.print("변환 할 값을 입력해주세요.(ex 사천삼백오십) : ");
				String input2 = in.readLine();
				hangulToNum(input2);
				break;
			case 3:
				break mainLoop;

			}
		}
		System.out.println("========================프로그램 종료========================");
	}

	// 한글을 숫자로 바꾸는 메서드
	public static void hangulToNum(String input) {

		long result = 0;
		long tmpResult = 0;
		long num = 0;

		final String NUMBER = "영일이삼사오육칠팔구";
		final String UNIT = "십백천만억조";
		final long[] UNIT_NUM = { 10, 100, 1000, 10000, (long) Math.pow(10, 8), (long) Math.pow(10, 12) };
		// pow(x,y) x의 y승 Math.pow(10, 8):억 (long) Math.pow(10, 12):조
		StringTokenizer st = new StringTokenizer(input, UNIT, true);
		// new StringTokenizer(input, UNIT, true); =>true는 UNIT도 구분자로 취급하겠다.라는뜻
		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			// 숫자인지,단위인지확인한다.
			int check = NUMBER.indexOf(token);
			if (check == -1) {// 단위의경우 //check == -1 : check가 없을 경우
				if ("만억조".indexOf(token) == -1) {
					tmpResult += (num != 0 ? num : 1) * UNIT_NUM[UNIT.indexOf(token)];
				} else {
					tmpResult += num;
					result += (tmpResult != 0 ? tmpResult : 1) * UNIT_NUM[UNIT.indexOf(token)];
					tmpResult = 0;
				}
				num = 0;
			} else {// 숫자인경우
				num = check;
			}
		} // end of while
		System.out.println(result + tmpResult + num);
	}

	// 숫자를 한글로 바꾸는 메서드
	public static void numTohangul(String input) {
		final String NUMBER[] = { "영", "일", "이", "삼", "사", "오", "육", "칠", "팔", "구" };
		final String UNIT[] = { "", "십", "백", "천", "만", "십", "백", "천", "억", "십", "백", "천", "조", "십", "백", "천", "만", "십",
				"백", "천", "억" };
		String result = "";
		String tmpResult = "";
		String token = "";
		long num = 0;
		char check = 0;

		final String digit = "0123456789";
		StringTokenizer st = new StringTokenizer(input, ",", false);

		while (st.hasMoreTokens()) {
			token = st.nextToken();
			tmpResult += token;
		}
		for (int i = 0, j = tmpResult.length() - 1; i < tmpResult.length(); i++, j--) {
			check = tmpResult.charAt(i);
			result += NUMBER[digit.indexOf(check)];
			if ((NUMBER[digit.indexOf(check)] != "영") || ((j % 4 == 0) && (result.equals(UNIT.toString())))) {
				result += UNIT[j];
			}
		}

		printNumTohangul(result);
	}

	// NumTohangul 출력 메서드
	public static void printNumTohangul(String result) {
		String print_result = result;
		String print_token = "";

		ArrayList list = new ArrayList<>();
		StringTokenizer st_last = new StringTokenizer(print_result, "영", false);

		while (st_last.hasMoreTokens()) {
			print_token = st_last.nextToken();
			// 위에서 생성된 토큰을 "영"을 기준으로 잘른다.
			StringTokenizer st_last2 = new StringTokenizer(print_token, "");
			while (st_last2.hasMoreTokens()) {
				list.add(st_last2.nextToken()); // st2를 list에저장
			}

		}
		String last_result = "";
		for (int i = 0; i < list.size(); i++) {
			last_result += list.get(i);
		}
		System.out.println(last_result);

	}

}

package Day14_160115;

import java.util.*;
import java.io.*;

public class CoinTest {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		final int[] COIN_UNIT = { 500, 50, 10, 1 };// 큰 단위를 앞에 놓는다.
		final String[] COIN_UNIT_NAME = { "500원", "50원 ", "10원 ", "1원  " };
		mainLoop: while (true) {
			try {
				System.out.println("======동전 교환기======");
				System.out.print("금액 입력 : ");
				int inputMoney = Integer.parseInt(in.readLine());

				String tmp = "";
				for (int i = 0; i < COIN_UNIT.length; i++) {// 동전개수 출력
					tmp = COIN_UNIT_NAME[i] + " : " + inputMoney / COIN_UNIT[i] + "개 ";
					inputMoney %= COIN_UNIT[i];
					System.out.println(tmp);
					// System.out.println(inputMoney);
				}
				break mainLoop;
			} catch (Exception e) {
				System.out.println("에러발생! 프로그램을 다시 실행합니다.");
			}
		}
		System.out.println("=========종 료=========");
	}
}

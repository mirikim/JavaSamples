package Day12_160113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class SnailTest {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.println("===========SnailTest=============");
				System.out.print("배열의 크기를 입력해주세요.ex)2,9 : ");
				int size = Integer.parseInt(in.readLine());
				int snail[][] = new int[size][size];

				int t = 1;
				for (int s = 0; s < snail.length / 2; s++) {
					// →→→→→→→→→→→→→
					for (int j = 0 + s; j < snail.length - s; j++) {
						snail[0 + s][j] = t;
						t++;
					}
					// ↓↓↓↓↓↓↓↓↓↓↓↓↓
					for (int i = 1 + s; i < snail.length - s; i++) {
						snail[i][snail.length - 1 - s] = t;
						t++;
					}
					// ←←←←←←←←←←←←←
					for (int k = snail.length - 2 - s; k >= 0 + s; k--) {
						snail[snail.length - 1 - s][k] = t;
						t++;
					}
					// ↑↑↑↑↑↑↑↑↑↑↑↑↑
					for (int h = snail.length - 2 - s; h > 0 + s; h--) {
						snail[h][0 + s] = t;
						t++;
					}

				}
				if (((snail.length % 2) != 0)) {
					snail[snail.length / 2][snail.length / 2] = snail.length * snail.length;
				}

				for (int i = 0; i < snail.length; i++) {
					for (int j = 0; j < snail.length; j++) {
						System.out.print(" " + snail[i][j] + " ");
					}
					System.out.println();
				}
				System.out.println("=================================");
				System.out.println(" ");
				break;
			} catch (Exception e) {
				System.out.println("");
				System.out.println("잘못된 입력 값입니다. 프로그램을 다시 실행합니다.");
			}
		}
	}
}

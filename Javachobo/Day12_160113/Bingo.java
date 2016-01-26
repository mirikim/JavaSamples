package Day12_160113;

import java.util.*;

public class Bingo {
	public static void main(String[] args) {
		Set set = new HashSet();
		int[][] board = new int[5][5];

		for (int i = 0; set.size() < 25; i++) {
			set.add((int) (Math.random() * 50) + 1 + "");
			// 랜덤으로 값을 set에 25개 저장한다(Set은 중복과 순서를 허용하지 않으므로
			// 중복 없이 순서상관없이 값을 저장할 수 있다.=>빙고에도 숫자를 랜덤하게 정렬없이 쓰므로
		}

		Iterator it = set.iterator();

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = Integer.parseInt((String) it.next());
				// set에 저장된값을 차례대로 board에 저장한다.
				// it.next()의 리턴값은 Object이므로 String으로 캐스팅해주어 Object타입으로 맞춰준다.
				System.out.print((board[i][j] < 10 ? " " : " ") + board[i][j]);
			}
			System.out.println("");
		}
	}
}

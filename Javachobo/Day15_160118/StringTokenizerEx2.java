package Day15_160118;

import java.util.*;

public class StringTokenizerEx2 {
	public static void main(String[] args) {
		String expression = "x=100*(200+300)/2";
		StringTokenizer st = new StringTokenizer(expression, "+-*/=()", true);
		//구분자 여러개 "+-*/=()" 를 함께 스트링형태로 묶어서 정의 할 수 있다.
		while (st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
	}
}

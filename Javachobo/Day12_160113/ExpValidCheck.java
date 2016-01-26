package Day12_160113;

import java.util.*;

public class ExpValidCheck {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Usage : java ExpValidCheck \"EXPRESSION\"");
			System.out.println("Example : java ExpValidCheck \"((2+3)*1)+3\"");
			System.exit(0);//프로그램종료 메소드

		}
		Stack st = new Stack();
		String expression = args[0];

		System.out.println("expression : " + expression);
		try {
			for (int i = 0; i < expression.length(); i++) {
				char ch = expression.charAt(i);//해당인덱스i에있는 값을 ch에 저장
				if (ch == '(') {
					st.push(ch + "");//'('이면 스택에 넣는다
				} else if (ch == ')') {//')'이면 스택에서 꺼낸다.
					st.pop();
				}
			}
			if (st.isEmpty()) {//괄호의 짝이 맞음
				System.out.println("괄호가 일치합니다.");
			} else {///괄호의 짝이 맞지 않음.
				System.out.println("괄호가 일치하지 않습니다.");
			}
		} catch (EmptyStackException e) {
			// TODO: handle exception
			System.out.println("괄호가 일치하지 않습니다2.");
		} // try
	}
}

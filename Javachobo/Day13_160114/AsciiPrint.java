package Day13_160114;

public class AsciiPrint {
	public static void main(String[] args) {
		char ch = ' ';
		// 공백(' ')이후의 문자들을 출력한다.
		for (int i = 0; i < 95; i++) {
			System.out.print(ch++ + " ");
		} // 아스키문자표의 시작은 ' ' 공백이다.
	}
}

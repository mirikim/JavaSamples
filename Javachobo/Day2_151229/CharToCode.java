package Day2_151229;

public class CharToCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char ch = 'A';// char ch ='\u0041';로 바꿔 써도 같다
		int code = (int) ch;// ch에 저장된 값을 int형으로 변환하여 code에 저장
		System.out.println(ch);
		System.out.println(code);

		/////////////////////////
		char ch2 = '\u0041';
		int code2 = (int) ch2;
		System.out.println(ch2);
		System.out.println(code2);
		/////////////////////////

		char ch3 = 'a';
		int code3 = (int) ch3;
		System.out.println(ch3);
		System.out.println(code3);

		if (0.1f == 0.1d) {
			System.out.println("true");
		} else {
			System.out.println("false");

		}
	}

}

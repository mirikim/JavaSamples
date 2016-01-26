package Day10_160111;

public class StringTest {
	static String str1 = " I wish you a Merry Christmas ";
	// static String str2 = "and a Happy new year.";

	public static void main(String[] args) {

		int index = str1.indexOf("Merry");
		System.out.println(index);// str1에 Merry가 저장된 index값

		String pre_Merry = str1.substring(0, index);// 0부터 index(Merry 전)까지의
													// 문자열을 저장
		System.out.println(pre_Merry);

		String str = str1.concat("and a Happy new year.");
		System.out.println(str);// str1뒤에 "and a Happy new year."을 덧붙인다.

		String New = str.replace("new", "New");// new를 New로 변경
		System.out.println(New);

		boolean b = str.startsWith(" I wish");// str이 " I wish"로 시작하는지 검사.
		System.out.println(b);

		boolean b1 = str.endsWith("year.");// str이 "year."로 끝나는지 검사.
		System.out.println(b1);

		String s2 = new String(" I wish you a Merry Christmas ");
		boolean b2 = (str1 == s2);
		System.out.println(b2);
		boolean b3 = (str1.intern() == s2.intern());
		System.out.println(b3);// constant pool에 등록 이미 constant pool에 같은 내용의
								// 문자열이 있을 경우 그문자열의 주소값 반환.

		String[] strArr = str.split("and", 2);// 문자열 str을 and로 2개나누어 strArr[]에
												// 저장
		for (int i = 0; i < strArr.length; i++) {
			System.out.println(strArr[i]);
		}

		String lowerStr = str.toLowerCase();// str문자열을 다 소문자로
		System.out.println(lowerStr);

		String upperStr = str.toUpperCase();
		System.out.println(upperStr);// str문자열을 다 대문자로

		String cleanStr = str.trim();// str의 왼쪽 끝과 오른쪽끝에 공백을 없앤 결과 반환
		System.out.println(cleanStr);

		StringCount sc = new StringCount(str);
		System.out.println("a를" + sc.stringCount("a") + "개 찾았습니다.");

	}
}
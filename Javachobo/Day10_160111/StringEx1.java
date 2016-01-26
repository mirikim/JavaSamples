package Day10_160111;

public class StringEx1 {
	public static void main(String[] args) {
		String str1 = "abc";
		String str2 = "abc";

		System.out.println("String str1 = \"abc\";");
		System.out.println("String str2 = \"abc\";");
		// ==참조변수 str1,2이 갖고있는 주소값을 비교
		if (str1 == str2) {
			System.out.println("str1 == str2 ? true");
		} else {
			System.out.println("str1 == str2 ? false");
		}
		// String class에서는 equals메소드를 상속받은다음 오버라이딩해서 주소값이 아닌 실제값을 비교하도록 한다.
		// .equals()메소드는 실제 값을 갖는 메소드이므로 str1과 str2에 저장된 실제값을 비교.
		if (str1.equals(str2)) {
			System.out.println("str1.equals(str2) ? true");
		} else {
			System.out.println("str1.equals(str2) ? false");
		}
		System.out.println();

		String str3 = new String("\"abc\"");
		String str4 = new String("\"abc\"");

		System.out.println("String str3 = new String(\"abc\");");
		System.out.println("String str4 = new String(\"abc\");");

		if (str3 == str4) {// str3,str4의 String객체는 각각의 new String("\"abc\"");을
							// 갖고있기때문에 다른객체를 가리킨다.
			// 따라서 다른 객체의 주소값을 갖고있다.
			System.out.println("str3 == str4 ? true");

		} else {
			System.out.println("str3 == str4 ? false");
		}
		if (str3.equals(str4)) {// str3,str4는 다른 객체를 가리키지만 다른 두 객체의 실제 값은 abc라는
								// 문자열이므로 값은 true
			System.out.println("str3.equals(str4) ? true");

		} else {
			System.out.println("str3.equals(str4) ? false");
		}
	}
}

package Day10_160111;

public class StringBufferEx1 {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("abc");// 생성자메소드를 사용해서 객체를 생성하면 각각 다른
													// 위치에 저장된다.
		StringBuffer sb2 = new StringBuffer("abc");

		if (sb == sb2) {// 주소값비교
			System.out.println("sb == sb2 ? true");
		} else {
			System.out.println("sb == sb2 ? false");
		}
		if (sb.equals(sb2)) {// StringBuffer는 equals를 오버라이딩하지 않는다. 따라서 주소값을 비교하게
								// 되있다.
			System.out.println("sb.equals(sb2) ? true");

		} else {
			System.out.println("sb.equals(sb2) ? false");
		}

		// StringBuffer의 내용을 String으로 변환한다.
		String s = sb.toString();// String s = new String(sb);와같다.
		String s2 = sb2.toString();// toString()메소드는 해당객체의 실제값을 문자열로 표시

		if (s.equals(s2)) {// String클래스의 equals메소드는 실제값을 비교하도록 오버라이딩 되어있다.
			System.out.println("s.equals(s2) ? true");
		} else {
			System.out.println("s.equals(s2) ? false");
		}

	}
}

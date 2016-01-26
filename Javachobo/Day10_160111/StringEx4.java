package Day10_160111;

public class StringEx4 {
	public static void main(String[] args) {
		String[] words = { new String("aaa"), new String("bbb"), new String("ccc") };
		// new String("")를 이용해 배열 값을 넣음
		// words[0]에는 문자열 aaa의 주소값이 저장되어있다.
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals("ccc")) {// 실제값비교
				System.out.println("words에서 equals메서드로 찾았습니다.");
			}
			if (words[i] == "ccc") {// 주소값비교
				System.out.println("words에서 ==연산자로 찾았습니다.");
			}
		}
		// intern메서드를 통해 constant pool에 각 배열 요소를 입력
		for (int i = 0; i < words.length; i++) {
			words[i] = words[i].intern();
		}
		System.out.println("<< String배열 words의 문자열에 intern메서드를 수행 >>");
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals("ccc")) {//
				System.out.println("words에서 equals메서드로 찾았습니다.");
			}
			if (words[i] == "ccc") {// intern메소드를통해 constant pool에 ccc가 저장되어있으므로
				// ccc라는 값을 갖고있는 주소를 가리키므로 ==연산자로 찾을 수 있다.
				System.out.println("words에서 == 연산자로 찾았습니다.");
			}
		}
	}// end of main
}// end of class

/// "==","equals()"중에 ==가 더빠르다. 더효과적이다 해당 주소값만 비교하면 되므로
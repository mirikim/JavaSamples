package Day10_160111;

public class StringEx3 {
	public static void main(String[] args) {

		String s1 = "AAA";
		String s2 = new String("AAA");
		if (s1 == s2)

		{
			System.out.println("s1==s2 ? true");
		} else

		{
			System.out.println("s1==s2 ? false");
		}

		s2 = s2.intern();// constant pool에 문자열 입력한후 이미 constant pool에 입력된 문자열이면
							// 그 주소값을 가리키게된다
		// 즉 s1이 먼저 constant pool에 저장되어있으므로 s2는 s1의 주소값을 갖게된다. 따라서 s1과 s2는 같은
		// 주소값을 가리킨다.
		System.out.println("s2에 intern()을 호출한 후");

		if (s1 == s2) {
			System.out.println("s1==s2 ? true");
		} else {
			System.out.println("s1==s2 ? false");
		}
	}
}

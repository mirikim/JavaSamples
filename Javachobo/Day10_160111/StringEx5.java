package Day10_160111;

public class StringEx5 {
	static String s;// 초기화안함. null
	static String s2 = "";// 빈문자열로초기화.

	public static void main(String[] args) {
		for (int i = 1; i < 10; i++) {
			s += i;// s = s + i;
			s2 += i;
		}
		System.out.println(s);
		System.out.println(s2);
	}
}

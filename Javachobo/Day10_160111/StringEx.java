package Day10_160111;

public class StringEx {
	public static void main(String[] args) {
		char c[] = { 'H', 'e', 'l', 'l', 'o' };
		String s = new String(c);
		System.out.println("char c [] = " + s);

		StringBuffer sb = new StringBuffer("Hello2");
		String s1 = new String(sb);
		System.out.println("StringBuffer sb = " + s1);

		String s2 = "Hello3";
		System.out.print("c2 = ");
		for (int i = 0; i < s2.length(); i++) {
			char c2 = s2.charAt(i);

			System.out.print(c2 + " ");
		}
		System.out.println("");

		String s3 = "java.lang.Object";
		int idx1 = s3.lastIndexOf("Object");// 못찾으면 -1을 반환한다.
		int idx2 = s3.indexOf("java");
		System.out.println("idx1 : " + idx1);
		System.out.println("idx2 : " + idx2);

		String ab = "AABBAABB";
		String r = ab.replace("BB", "bb");// 문자열 ab에있는 BB를 bb로 replace한다.
		System.out.println(r);

		String animals = "dog,cat,bear";
		String[] arr = animals.split(",", 3);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("");
	}

}

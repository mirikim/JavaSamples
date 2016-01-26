package Day10_160111;

public class StringCount {
	private int count;// stringCount의 멤버변수1
	private String source = "";// stringCount의 멤버변수2

	public StringCount(String source) {// stringCount의 멤버메소드1
		this.source = source;
	}

	public int stringCount(String s) {// stringCount의 멤버메소드2
		return stringCount(s, 0);
	}

	public int stringCount(String s, int pos) {// stringCount의 멤버메소드3
		int index = 0;
		if (s == null || s.length() == 0)
			return 0;
		if ((index = source.indexOf(s, pos)) != -1) {
			count++;
			stringCount(s, index + s.length());// 재귀호출
		}
		return count;
	}

	public static void main(String[] args) {// stringCount의 멤버메소드4
		String str = "aabbccAABBCCaa";
		System.out.println(str);
		StringCount sc = new StringCount(str);
		System.out.println("aa를 " + sc.stringCount("aa") + "개 찾았습니다.");
	}
}

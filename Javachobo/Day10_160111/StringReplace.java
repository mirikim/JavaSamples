package Day10_160111;

public class StringReplace {

	private String source = "";
	private int length;
	private StringBuffer buffer;

	public StringReplace(String source) {
		this.source = source;
		length = source.length();
		buffer = new StringBuffer(length + 100);
	}

	public int length() {
		return length;
	}

	public String replace(String old, String nw) {
		return replace(old, nw, 0);
	}

	public String replace(String old, String nw, int pos) {
		int index = 0;
		if (old == null || nw == null)
			return "null";
		if ((index = source.indexOf(old, pos)) != -1) {//index = source.indexOf(old, pos)) != -1 : 스트링버퍼의 끝을 만날때까지
			//index = source.indexOf(old, pos)=3이다(111이 시작하는 인덱스값)
			buffer.append(source.substring(pos, index));//스트링버퍼 인덱스 pos(0)부터 index(3)전까지 nw(AAA)로 바꾸기
			buffer.append(nw);
			// 발견한 위치 이후부터 다시 치환을 시작한다.
			replace(old, nw, index + old.length());// 재귀 함수호출
			// 치환한 위치 다음부터 다시 시작할 위치 old.length()

		} else {
			// 더이상 치환할 문자열을 못찾으면 나머지 문자열을 buffer에
			buffer.append(source.substring(pos));
		}
		return buffer.toString();// buffer에 저장된 값을 String으로 변환하여 리턴
	}

	public static void main(String[] args) {
		String str = "000111222333111222333";
		System.out.println(str);
		StringReplace sc = new StringReplace(str);
		System.out.println(sc.replace("111", "AAA"));
	}
}
